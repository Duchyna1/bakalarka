import datalog.Query;
import ra.RAExpr;

import java.util.LinkedHashMap;
import java.util.Map;

public class CompiledRAProgram {
    private final Map<String, RAExpr> relations;
    private final RAExpr queryExpression;
    private final Query sourceQuery;

    public CompiledRAProgram(Map<String, RAExpr> relations, RAExpr queryExpression, Query sourceQuery) {
        this.relations = new LinkedHashMap<>(relations);
        this.queryExpression = queryExpression;
        this.sourceQuery = sourceQuery;
    }

    public Map<String, RAExpr> getRelations() {
        return new LinkedHashMap<>(relations);
    }

    public boolean hasQuery() {
        return queryExpression != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (queryExpression != null) {
            sb.append(queryExpression).append(".\n");
        }

        return sb.toString();
    }
}
