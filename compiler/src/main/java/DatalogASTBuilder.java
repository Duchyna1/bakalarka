import datalog.*;
import common.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class DatalogASTBuilder extends datalogBaseVisitor<Object> {
    
    @Override
    public DatalogProgram visitProgram(datalogParser.ProgramContext ctx) {
        List<Clause> clauses = new ArrayList<>();
        List<Definition> definitions = new ArrayList<>();
        
        // Build clauses
        for (datalogParser.ClauseContext clauseCtx : ctx.clause()) {
            clauses.add(visitClause(clauseCtx));
        }
        
        // Build definitions
        for (datalogParser.DefinitionContext defCtx : ctx.definition()) {
            definitions.add(visitDefinition(defCtx));
        }
        
        // Build query
        Query query = visitQuery(ctx.query());
        
        return new DatalogProgram(clauses, definitions, query);
    }
    
    @Override
    public Clause visitClause(datalogParser.ClauseContext ctx) {
        // Build head predicate
        String headName = ctx.name().getText();
        List<Term> headTerms = new ArrayList<>();
        
        if (ctx.term() != null && !ctx.term().isEmpty()) {
            for (datalogParser.TermContext termCtx : ctx.term()) {
                headTerms.add(visitTerm(termCtx));
            }
        }
        
        Predicate head = new Predicate(headName, headTerms, false);
        
        // Build body atoms
        List<Atom> body = new ArrayList<>();
        for (int i = 0; i < ctx.children.size(); i++) {
            ParseTree child = ctx.children.get(i);
            if (child instanceof datalogParser.PredicateContext) {
                // Child is predicate
                datalogParser.PredicateContext predCtx = (datalogParser.PredicateContext) child;
                Predicate pred = visitPredicate(predCtx);
                boolean isNegated = predCtx.negative_predicate() != null;
                body.add(new Atom(pred, isNegated));
            } else if (child instanceof datalogParser.Built_in_predicateContext) {
                // Child is built-in predicate
                datalogParser.Built_in_predicateContext bipCtx = (datalogParser.Built_in_predicateContext) child;
                Predicate pred = visitBuilt_in_predicate(bipCtx);
                boolean isNegated = bipCtx.negative_buit_in_predicate() != null;
                body.add(new Atom(pred, isNegated));
            }
        }
        
        Clause clause = new Clause(head, body);
        String safetyError = clause.isSafe();
        if (safetyError != null) {
            throw new IllegalArgumentException("Clause is not safe: " + clause + " - " + safetyError);
        }
        
        return clause;
    }
    
    @Override
    public Predicate visitNormal_predicate(datalogParser.Normal_predicateContext ctx) {
        String name = ctx.name().getText();
        List<Term> terms = new ArrayList<>();
        
        // Build terms
        if (ctx.term() != null) {
            for (datalogParser.TermContext termCtx : ctx.term()) {
                terms.add(visitTerm(termCtx));
            }
        }
        
        return new Predicate(name, terms, false);
    }
    
    @Override
    public Predicate visitPredicate(datalogParser.PredicateContext ctx) {
        if (ctx.normal_predicate() != null) {
            // Is a normal predicate
            return visitNormal_predicate(ctx.normal_predicate());
        } else {
            // Is a negative predicate
            return visitNormal_predicate(ctx.negative_predicate().normal_predicate());
        }
    }
    
    @Override
    public Predicate visitBuilt_in_predicate(datalogParser.Built_in_predicateContext ctx) {
        if (ctx.normal_built_in_predicate() != null) {
            // Is a normal built-in predicate
            return visitNormal_built_in_predicate(ctx.normal_built_in_predicate());
        } else {
            // Is a negative built-in predicate
            return visitNormal_built_in_predicate(
                ctx.negative_buit_in_predicate().normal_built_in_predicate()
            );
        }
    }
    
    @Override
    public Predicate visitNormal_built_in_predicate(datalogParser.Normal_built_in_predicateContext ctx) {
        String name = ctx.name().getText();
        List<Term> terms = new ArrayList<>();

        // Build parameters
        if (ctx.parameter() != null) {
            for (datalogParser.ParameterContext paramCtx : ctx.parameter()) {
                terms.add(visitBuiltInParameter(paramCtx));
            }
        }
        
        return new Predicate(name, terms, true);
    }

    private Term visitBuiltInParameter(datalogParser.ParameterContext paramCtx) {
        if (paramCtx.term() != null) {
            // Is term
            return visitTerm(paramCtx.term());
        }

        return new Parameter(paramCtx.getText());
    }
    
    @Override
    public Definition visitDefinition(datalogParser.DefinitionContext ctx) {
        String name = ctx.name().getText();
        int arity = Integer.parseInt(ctx.arity().getText());
        List<List<Term>> tuples = new ArrayList<>();
        
        // Build tuples
        for (datalogParser.Term_tupleContext tupleCtx : ctx.term_tuple()) {
            // Build a tuple of terms
            List<Term> tuple = new ArrayList<>();
            for (datalogParser.TermContext termCtx : tupleCtx.term()) {
                tuple.add(visitTerm(termCtx));
            }
            tuples.add(tuple);
        }
        
        return new Definition(name, arity, tuples);
    }
    
    @Override
    public Query visitQuery(datalogParser.QueryContext ctx) {
        Predicate pred;
        if (ctx.normal_predicate() != null) {
            // Is a normal predicate
            pred = visitNormal_predicate(ctx.normal_predicate());
        } else {
            // Is a built-in predicate
            pred = visitNormal_built_in_predicate(ctx.normal_built_in_predicate());
        }
        return new Query(pred);
    }
    
    @Override
    public Term visitTerm(datalogParser.TermContext ctx) {
        if (ctx.variable() != null) {
            String varName = ctx.variable().getText();
            if (Character.isUpperCase(varName.charAt(0))) {
                // If starts with uppercase letter, it's a variable
                return new Variable(varName);
            } else {
                // Otherwise, it's a constants
                return new Constant(varName);
            }
        } else if (ctx.function() != null) {
            // Is a function term
            String funcName = ctx.function().getText();
            List<Term> args = new ArrayList<>();
            
            // Build function arguments
            if (ctx.term() != null) {
                for (datalogParser.TermContext termCtx : ctx.term()) {
                    args.add(visitTerm(termCtx));
                }
            }
            
            return new FunctionTerm(funcName, args);
        }
        
        throw new RuntimeException("Unknown term type: " + ctx.getText());
    }
}
