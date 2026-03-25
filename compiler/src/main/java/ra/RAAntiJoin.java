package ra;

import common.Term;
import java.util.*;

public class RAAntiJoin extends RAExpr {
    private final List<RAExpr> relations;
    private final List<List<Term>> inputTerms;
    private final List<Term> outputTerms;
    
    public RAAntiJoin(List<RAExpr> relations, List<List<Term>> inputTerms, List<Term> outputTerms) {
        this.relations = new ArrayList<>(relations);
        this.inputTerms = new ArrayList<>();
        for (List<Term> terms : inputTerms) {
            this.inputTerms.add(new ArrayList<>(terms));
        }
        this.outputTerms = new ArrayList<>(outputTerms);
    }
    
    public List<RAExpr> getRelations() {
        return new ArrayList<>(relations);
    }
    
    public List<List<Term>> getInputTerms() {
        List<List<Term>> result = new ArrayList<>();
        for (List<Term> terms : inputTerms) {
            result.add(new ArrayList<>(terms));
        }
        return result;
    }
    
    public List<Term> getOutputTerms() {
        return new ArrayList<>(outputTerms);
    }
    
    private String tupleToString(List<Term> tuple) {
        return "[" + String.join(", ", 
                tuple.stream()
                .map(Term::toString)
                .toArray(String[]::new)) + "]";
    }
    
    @Override
    public String toString() {
        String relationsString = String.join(", ", 
                relations.stream()
                .map(RAExpr::toString)
                .toArray(String[]::new));
        String inputTermsString = String.join(", ", 
                inputTerms.stream()
                .map(this::tupleToString)
                .toArray(String[]::new));
        String outputTermsString = String.join(", ", 
                outputTerms.stream()
                .map(Term::toString)
                .toArray(String[]::new));
        
        return "ANTIJOIN([" + relationsString + "], [" + inputTermsString + "], [" + outputTermsString + "])";
    }
}
