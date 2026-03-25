package datalog;

import common.Term;
import java.util.*;

public class Predicate {
    private final String name;
    private final List<Term> terms;
    private final boolean isBuiltIn;
    
    public Predicate(String name, List<Term> terms, boolean isBuiltIn) {
        this.name = name;
        this.terms = new ArrayList<>(terms);
        this.isBuiltIn = isBuiltIn;
    }
    
    public String getName() {
        return name;
    }
    
    public List<Term> getTerms() {
        return new ArrayList<>(terms);
    }
    
    public boolean isBuiltIn() {
        return isBuiltIn;
    }
    
    public int getArity() {
        return terms.size();
    }
    
    public Set<String> getVariables() {
        Set<String> vars = new HashSet<>();
        for (Term term : terms) {
            vars.addAll(term.getVariables());
        }
        return vars;
    }
    
    @Override
    public String toString() {
        return (isBuiltIn ? "$" : "") + name + "(" + 
            String.join(", ", terms.stream().map(Term::toString).toArray(String[]::new)) + ")";
    }
}
