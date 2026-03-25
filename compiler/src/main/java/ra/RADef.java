package ra;

import common.Term;
import java.util.*;

public class RADef extends RAExpr {
    private final List<List<Term>> tuples;
    
    private void checkArrity(List<List<Term>> tuples) {
        if (tuples.isEmpty()) return;
        int arity = tuples.get(0).size();
        for (List<Term> tuple : tuples) {
            if (tuple.size() != arity) {
                throw new IllegalArgumentException("All tuples in a definition must have the same arity");
            }
        }
    }
    
    private void checkVariables(List<List<Term>> tuples) {
        for (List<Term> tuple : tuples) {
            for (Term term : tuple) {
                if (term.getVariables().size() > 0) {
                    throw new IllegalArgumentException("Tuples in a definition cannot contain variables");
                }
            }
        }
    }
    
    public RADef(List<List<Term>> tuples) {
        this.tuples = new ArrayList<>();
        this.checkArrity(tuples);
        this.checkVariables(tuples);
        for (List<Term> tuple : tuples) {
            this.tuples.add(new ArrayList<>(tuple));
        }
    }
    
    public List<List<Term>> getTuples() {
        List<List<Term>> result = new ArrayList<>();
        for (List<Term> tuple : tuples) {
            result.add(new ArrayList<>(tuple));
        }
        return result;
    }
    
    private String tupleToString(List<Term> tuple) {
        return "[" + String.join(", ", 
                tuple.stream()
                .map(Term::toString)
                .toArray(String[]::new)) + "]";
    }
    
    @Override
    public String toString() {
        if (tuples.isEmpty()) {
            return "DEF()";
        }
        
        return "DEF([" + String.join(", ", 
                tuples.stream()
                .map(this::tupleToString)
                .toArray(String[]::new))
        + "])";
    }
}
