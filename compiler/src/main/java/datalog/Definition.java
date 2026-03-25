package datalog;

import common.Term;
import java.util.*;

public class Definition {
    private final String name;
    private final int arity;
    private final List<List<Term>> tuples;
    
    public Definition(String name, int arity, List<List<Term>> tuples) {
        this.name = name;
        this.arity = arity;
        this.tuples = new ArrayList<>();
        for (List<Term> tuple : tuples) {
            if (tuple.size() != arity) {
                throw new IllegalArgumentException("Tuple arity does not match definition arity");
            }
            
            for (Term term : tuple) {
                if (term.getVariables().size() > 0) {
                    throw new IllegalArgumentException("Tuples in a definition cannot contain variables");
                }
            }
            
            this.tuples.add(new ArrayList<>(tuple));
        }
    }
    
    public String getName() {
        return name;
    }
    
    public int getArity() {
        return arity;
    }
    
    public List<List<Term>> getTuples() {
        List<List<Term>> result = new ArrayList<>();
        for (List<Term> tuple : tuples) {
            result.add(new ArrayList<>(tuple));
        }
        return result;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("(").append(arity).append(") :- {");
        for (int i = 0; i < tuples.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append("(");
            List<Term> tuple = tuples.get(i);
            for (int j = 0; j < tuple.size(); j++) {
                if (j > 0) sb.append(", ");
                sb.append(tuple.get(j));
            }
            sb.append(")");
        }
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return arity == that.arity && Objects.equals(name, that.name);
    }
}
