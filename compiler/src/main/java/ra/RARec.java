package ra;

public class RARec extends RAExpr {
    private final String name;
    private final RAExpr relation;
    
    public RARec(String name, RAExpr relation) {
        this.name = name;
        this.relation = relation;
    }
    
    public String getName() {
        return name;
    }
    
    public RAExpr getRelation() {
        return relation;
    }
    
    @Override
    public String toString() {
        return "REC(" + name + ", " + relation.toString() + ")";
    }
}
