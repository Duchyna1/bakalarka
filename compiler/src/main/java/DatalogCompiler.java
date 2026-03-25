import common.FunctionTerm;
import common.Term;
import common.Variable;
import datalog.Atom;
import datalog.Clause;
import datalog.DatalogProgram;
import datalog.Definition;
import datalog.Predicate;
import datalog.Query;
import ra.RAAntiJoin;
import ra.RADef;
import ra.RAExpr;
import ra.RAJoin;
import ra.RARec;
import ra.RAUnion;
import ra.RelationRef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DatalogCompiler {
    public CompiledRAProgram compile(DatalogProgram program) {
        Map<String, List<RAExpr>> compiledDefinitions = compileDefinitions(program.getDefinitions());
        Map<String, RAExpr> combinedDefinitions = combineDefinitions(compiledDefinitions);
        Map<String, RAExpr> transformedDefinitions = transformeDefinitions(combinedDefinitions);
        
        for (Map.Entry<String, RAExpr> entry : transformedDefinitions.entrySet()) {
            String name = entry.getKey();
            RAExpr expr = entry.getValue();
            List<RAExpr> mutableList = new ArrayList<>();
            mutableList.add(expr);
            compiledDefinitions.put(name, mutableList);
        }
        
        Map<String, RAExpr> compiledClauses = compileClauses(program.getClausesByPredicate());
        
        for (Map.Entry<String, RAExpr> entry : compiledClauses.entrySet()) {
            String predicateName = entry.getKey();
            RAExpr clauseExpr = entry.getValue();
            if (compiledDefinitions.containsKey(predicateName)) {
                List<RAExpr> newDefs = compiledDefinitions.get(predicateName);
                newDefs.add(clauseExpr);
                compiledDefinitions.put(predicateName, newDefs);
            } else {
                List<RAExpr> mutableList = new ArrayList<>();
                mutableList.add(clauseExpr);
                compiledDefinitions.put(predicateName, mutableList);
            }
        }
        
        Map<String, RAExpr> relations = mergeDefinitions(compiledDefinitions);
                
        Map<String, List<String>> relationsReferenceGraph = buildRelationsReferenceGraph(relations);
        Map<String, RAExpr> finalRelations = new LinkedHashMap<>();
        for (String relationName : relations.keySet()) {
            RAExpr relationExpr = relations.get(relationName);
            if (isRecursive(relationsReferenceGraph, relationName))
                relationExpr = new RARec(relationName, relationExpr);
            finalRelations.put(relationName, relationExpr);
        }
        
        Map<String, RAExpr> inlinedExprs = inlineExpressions(finalRelations);
        
        Query query = program.getQuery();
        RAExpr queryExpr = null;
        if (query != null) {
            queryExpr = inlinedExprs.get(query.getPredicate().getName());
        }
        List<Term> headTerms = query.getPredicate().getTerms();
        List<RAExpr> queryRelations = new ArrayList<>();
        queryRelations.add(queryExpr);
        List<List<Term>> queryInputTerms = new ArrayList<>();
        queryInputTerms.add(headTerms);
        queryExpr = new RAJoin(queryRelations, queryInputTerms, headTerms);
        
        return new CompiledRAProgram(inlinedExprs, queryExpr, query);
    }

    private Map<String, RAExpr> combineDefinitions(Map<String, List<RAExpr>> compiledDefinitions) {
        Map<String, RAExpr> combinedDefinitions = new LinkedHashMap<>();
        
        for (Map.Entry<String, List<RAExpr>> entry : compiledDefinitions.entrySet()) {
            String name = entry.getKey();
            List<RAExpr> definitions = entry.getValue();
            
            List<List<Term>> allTuples = new ArrayList<>();
            for (RAExpr def : definitions) 
                if (def instanceof RADef) 
                    allTuples.addAll(((RADef) def).getTuples());
            
            combinedDefinitions.put(name, new RADef(allTuples));
        }
        return combinedDefinitions;
    }
    
    private Map<String, RAExpr> transformeDefinitions(Map<String, RAExpr> combinedDefinitions) {
        Map<String, RAExpr> transformedDefinitions = new LinkedHashMap<>();
        
        for (Map.Entry<String, RAExpr> entry : combinedDefinitions.entrySet()) {
            String name = entry.getKey();
            RAExpr def = entry.getValue();
            
            if (def instanceof RADef) {
                List<List<Term>> tuples = ((RADef) def).getTuples();
                List<RAExpr> tupleExprs = new ArrayList<>();
                
                for (List<Term> tuple : tuples) {
                    List<RAExpr> relations = new ArrayList<>();
                    relations.add(new RelationRef("true", true));
                    List<List<Term>> inputTerms = new ArrayList<>();
                    inputTerms.add(List.of());
                    tupleExprs.add(new RAJoin(relations, inputTerms, tuple));
                }
                if (tupleExprs.size() == 1)
                    transformedDefinitions.put(name, tupleExprs.get(0));
                else
                    transformedDefinitions.put(name, new RAUnion(tupleExprs));
            } 
        }
        return transformedDefinitions;
    }
    
    private Map<String, List<RAExpr>> compileDefinitions(List<Definition> definitions) {
        Map<String, List<RAExpr>> compiledDefinitions = new LinkedHashMap<>();
        
        for (Definition definition : definitions) {
            if (!compiledDefinitions.containsKey(definition.getName())) {
                compiledDefinitions.put(definition.getName(), new ArrayList<>());
            }
            compiledDefinitions.get(definition.getName()).add(new RADef(definition.getTuples()));
        }
        return compiledDefinitions;
    }

    private Map<String, RAExpr> mergeDefinitions(Map<String, List<RAExpr>> compiledDefinitions) {
        Map<String, RAExpr> mergedDefinitions = new LinkedHashMap<>();
        
        for (Map.Entry<String, List<RAExpr>> entry : compiledDefinitions.entrySet()) {
            String name = entry.getKey();
            List<RAExpr> definitions = entry.getValue();
            
            if (definitions.size() == 1) {
                mergedDefinitions.put(name, definitions.get(0));
            } else {
                RAUnion union = new RAUnion(definitions);
                mergedDefinitions.put(name, union);
            }
        }
        return mergedDefinitions;
    }
    
    private Map<String, RAExpr> compileClauses(Map<String, List<Clause>> clauses) {
        Map<String, RAExpr> clauseDefinitions = new LinkedHashMap<>();
        
        for (Map.Entry<String, List<Clause>> entry : clauses.entrySet()) {
            String predicateName = entry.getKey();
            List<Clause> predicateClauses = entry.getValue();
            
            List<RAExpr> clauseExprs = new ArrayList<>();
            for (Clause clause : predicateClauses) {
                RAExpr clauseExpr = compileClause(clause);
                clauseExprs.add(clauseExpr);
            }
            RAExpr combinedExpr;
            if (clauseExprs.size() == 1) {
                combinedExpr = clauseExprs.get(0);
            } else {
                combinedExpr = new RAUnion(clauseExprs);
            }
            clauseDefinitions.put(predicateName, combinedExpr);
        }
        
        return clauseDefinitions;
    }
    
    private RAExpr compileClause(Clause clause) {
        List<Term> headTerms = clause.getHead().getTerms();
        List<Atom> positiveBodyAtoms = new ArrayList<>();
        List<Atom> negativeBodyAtoms = new ArrayList<>();
        
        for (Atom bodyAtom : clause.getBody()) {
            if (bodyAtom.isNegated()) {
                negativeBodyAtoms.add(bodyAtom);
            } else {
                positiveBodyAtoms.add(bodyAtom);
            }
        }
        
        // Only one positive body atom
        if (positiveBodyAtoms.size() == 1 && negativeBodyAtoms.isEmpty()) {
            Atom atom = positiveBodyAtoms.get(0);
            RAExpr atomExpr = new RelationRef(atom.getPredicate().getName(), atom.getPredicate().isBuiltIn());
            List<RAExpr> relations = new ArrayList<>();
            relations.add(atomExpr);
            List<List<Term>> inputTerms = new ArrayList<>();
            inputTerms.add(atom.getPredicate().getTerms());
            return new RAJoin(relations, inputTerms, headTerms);
        }
        
        // Only positive body atoms
        if (negativeBodyAtoms.isEmpty()) {
            List<RAExpr> positiveBodyRelations = new ArrayList<>();
            for (Atom atom : positiveBodyAtoms) {
                positiveBodyRelations.add(new RelationRef(atom.getPredicate().getName(), atom.getPredicate().isBuiltIn()));
            }
            List<List<Term>> inputTerms = new ArrayList<>();
            for (Atom atom : positiveBodyAtoms) {
                inputTerms.add(atom.getPredicate().getTerms());
            }
            return new RAJoin(positiveBodyRelations, inputTerms, headTerms);
        }
        
        // Both positive and negative body atoms
        List<RAExpr> positiveBodyRelations = new ArrayList<>();
        for (Atom atom : positiveBodyAtoms) {
            positiveBodyRelations.add(new RelationRef(atom.getPredicate().getName(), atom.getPredicate().isBuiltIn()));
        }
        List<List<Term>> positiveInputTerms = new ArrayList<>();
        for (Atom atom : positiveBodyAtoms) {
            positiveInputTerms.add(atom.getPredicate().getTerms());
        }
        List<Term> positiveOutputTerms = new ArrayList<>(new LinkedHashSet<>(positiveInputTerms.stream().flatMap(List::stream).toList()));
        RAExpr positiveJoin = new RAJoin(positiveBodyRelations, positiveInputTerms, positiveOutputTerms);
        
        List<RAExpr> negativeBodyRelations = new ArrayList<>();
        negativeBodyRelations.add(positiveJoin);
        for (Atom atom : negativeBodyAtoms) {
            negativeBodyRelations.add(new RelationRef(atom.getPredicate().getName(), atom.getPredicate().isBuiltIn()));
        }
        List<List<Term>> negativeInputTerms = new ArrayList<>();
        negativeInputTerms.add(positiveOutputTerms);
        for (Atom atom : negativeBodyAtoms) {
            negativeInputTerms.add(atom.getPredicate().getTerms());
        }
        RAExpr finalExpr = new RAAntiJoin(negativeBodyRelations, negativeInputTerms, headTerms);
        
        return finalExpr;
    }
    
    private Set<String> collectReferencedRelations(RAExpr expr) {
        Set<String> referencedRelations = new LinkedHashSet<>();
        if (expr instanceof RelationRef) {
            referencedRelations.add(((RelationRef) expr).getName());
        } else if (expr instanceof RAJoin) {
            for (RAExpr subExpr : ((RAJoin) expr).getRelations()) {
                referencedRelations.addAll(collectReferencedRelations(subExpr));
            }
        } else if (expr instanceof RAAntiJoin) {
            for (RAExpr subExpr : ((RAAntiJoin) expr).getRelations()) {
                referencedRelations.addAll(collectReferencedRelations(subExpr));
            }
        } else if (expr instanceof RAUnion) {
            for (RAExpr subExpr : ((RAUnion) expr).getRelations()) {
                referencedRelations.addAll(collectReferencedRelations(subExpr));
            }
        } else if (expr instanceof RARec) {
            referencedRelations.addAll(collectReferencedRelations(((RARec) expr).getRelation()));
            referencedRelations.add(((RARec) expr).getName());
        }
        return referencedRelations;
    }
    
    private Map<String, List<String>> buildRelationsReferenceGraph(Map<String, RAExpr> relations) {
        Map<String, List<String>> graph = new LinkedHashMap<>();
        
        for (Map.Entry<String, RAExpr> entry : relations.entrySet()) {
            String relationName = entry.getKey();
            RAExpr expr = entry.getValue();
            Set<String> referencedRelations = collectReferencedRelations(expr);
            graph.put(relationName, new ArrayList<>(referencedRelations));
        }
        
        return graph;
    }
    
    private boolean dfs(Map<String, List<String>> graph, String current, Set<String> visited) {
        if (visited.contains(current)) {
            return true; // Cycle detected
        }
        visited.add(current);
        for (String neighbor : graph.getOrDefault(current, Collections.emptyList())) {
            if (dfs(graph, neighbor, visited)) {
                return true;
            }
        }
        visited.remove(current);
        return false;
    }
    
    private boolean isRecursive(Map<String, List<String>> graph, String relationName) {
        Set<String> visited = new LinkedHashSet<>();
        return dfs(graph, relationName, visited);
    }
    
    private RAExpr inlineExpression(RAExpr expr, Map<String, RAExpr> relations, List<String> dontInline) {
        if (expr instanceof RelationRef) {
            String relationName = ((RelationRef) expr).getName();
            if (dontInline.contains(relationName)) {
                return expr;
            }
            
            if (relations.containsKey(relationName)) {
                return inlineExpression(relations.get(relationName), relations, dontInline);
            } else {
                return expr;
            }
        } else if (expr instanceof RAJoin) {
            List<RAExpr> inlinedRelations = new ArrayList<>();
            for (RAExpr subExpr : ((RAJoin) expr).getRelations()) {
                inlinedRelations.add(inlineExpression(subExpr, relations, dontInline));
            }
            return new RAJoin(inlinedRelations, ((RAJoin) expr).getInputTerms(), ((RAJoin) expr).getOutputTerms());
        } else if (expr instanceof RAAntiJoin) {
            List<RAExpr> inlinedRelations = new ArrayList<>();
            for (RAExpr subExpr : ((RAAntiJoin) expr).getRelations()) {
                inlinedRelations.add(inlineExpression(subExpr, relations, dontInline));
            }
            return new RAAntiJoin(inlinedRelations, ((RAAntiJoin) expr).getInputTerms(), ((RAAntiJoin) expr).getOutputTerms());
        } else if (expr instanceof RAUnion) {
            List<RAExpr> inlinedRelations = new ArrayList<>();
            for (RAExpr subExpr : ((RAUnion) expr).getRelations()) {
                inlinedRelations.add(inlineExpression(subExpr, relations, dontInline));
            }
            return new RAUnion(inlinedRelations);
        } else if (expr instanceof RARec) {
            List<String> newDontInline = new ArrayList<>(dontInline);
            newDontInline.add(((RARec) expr).getName());
            RAExpr inlinedRelation = inlineExpression(((RARec) expr).getRelation(), relations, newDontInline);
            return new RARec(((RARec) expr).getName(), inlinedRelation);
        } else {
            return expr;
        }
    }
    
    private Map<String, RAExpr> inlineExpressions(Map<String, RAExpr> relations) {
        Map<String, RAExpr> inlinedRelations = new LinkedHashMap<>();
        
        for (Map.Entry<String, RAExpr> entry : relations.entrySet()) {
            String relationName = entry.getKey();
            RAExpr expr = entry.getValue();
            RAExpr inlinedExpr = inlineExpression(expr, relations, Collections.singletonList(relationName));
            inlinedRelations.put(relationName, inlinedExpr);
        }
        
        return inlinedRelations;
    }
}
