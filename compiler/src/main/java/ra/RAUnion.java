package ra;

import java.util.*;
import common.Term;

public class RAUnion extends RAExpr {
    private final List<RAExpr> relations;
    
    public RAUnion(List<RAExpr> relations) {
        this.relations = new ArrayList<>(relations);
    }
    
    public List<RAExpr> getRelations() {
        return new ArrayList<>(relations);
    }
    
    @Override
    public String toString() {
        return "UNION([" + String.join(", ", 
                relations.stream()
                .map(RAExpr::toString)
                .toArray(String[]::new)) + "])";
    }
}
