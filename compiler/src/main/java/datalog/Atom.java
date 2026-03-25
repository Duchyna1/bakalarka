package datalog;

import java.util.Set;

public class Atom {
    private final Predicate predicate;
    private final boolean isNegated;
    
    public Atom(Predicate predicate, boolean isNegated) {
        this.predicate = predicate;
        this.isNegated = isNegated;
    }
    
    public Predicate getPredicate() {
        return predicate;
    }
    
    public boolean isNegated() {
        return isNegated;
    }
    
    public Set<String> getVariables() {
        return predicate.getVariables();
    }
    
    @Override
    public String toString() {
        return (isNegated ? "\\+" : "") + predicate;
    }
}
