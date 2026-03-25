package ra;

public class RelationRef extends RAExpr {
    private final String name;
    private final boolean isBuiltIn;
    
    public RelationRef(String name, boolean isBuiltIn) {
        this.name = name;
        this.isBuiltIn = isBuiltIn;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isBuiltIn() {
        return isBuiltIn;
    }
    
    @Override
    public String toString() {
        return (isBuiltIn ? "$" : "") + name;
    }
}
