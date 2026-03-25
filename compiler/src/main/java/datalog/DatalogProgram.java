package datalog;

import java.util.*;

public class DatalogProgram {
    private final List<Clause> clauses;
    private final List<Definition> definitions;
    private final Query query;
    
    public DatalogProgram(List<Clause> clauses, List<Definition> definitions, Query query) {
        this.clauses = new ArrayList<>(clauses);
        this.definitions = new ArrayList<>(definitions);
        this.query = query;
    }
    
    public List<Definition> getDefinitions() {
        return new ArrayList<>(definitions);
    }
    
    public Query getQuery() {
        return query;
    }
    
    public boolean hasQuery() {
        return query != null;
    }
    
    public Map<String, List<Clause>> getClausesByPredicate() {
        Map<String, List<Clause>> map = new HashMap<>();
        for (Clause clause : clauses) {
            String name = clause.getHead().getName();
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
            }
            map.get(name).add(clause);
        }
        return map;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (!definitions.isEmpty()) {
            sb.append("% Definitions\n");
            for (Definition def : definitions) {
                sb.append(appendPeriod(def.toString())).append("\n");
            }
        }

        if (!clauses.isEmpty()) {
            if (!definitions.isEmpty()) {
                sb.append("\n");
            }
            sb.append("% Clauses\n");
            for (Clause clause : clauses) {
                sb.append(appendPeriod(clause.toString())).append("\n");
            }
        }

        if (query != null) {
            if (!definitions.isEmpty() || !clauses.isEmpty()) {
                sb.append("\n");
            }
            sb.append("% Query\n");
            sb.append(appendPeriod(query.toString())).append("\n");
        }

        return sb.toString();
    }

    private static String appendPeriod(String line) {
        return line.endsWith(".") ? line : line + ".";
    }
}
