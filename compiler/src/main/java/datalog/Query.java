package datalog;

public class Query {
    private final Predicate predicate;
    
    public Query(Predicate predicate) {
        this.predicate = predicate;
    }
    
    public Predicate getPredicate() {
        return predicate;
    }
    
    @Override
    public String toString() {
        return "?- " + predicate + ".";
    }
}
