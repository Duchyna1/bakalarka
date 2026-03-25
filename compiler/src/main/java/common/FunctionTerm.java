package common;

import java.util.*;
import java.util.stream.Collectors;

public class FunctionTerm extends Term {
    private final String name;
    private final List<Term> arguments;
    
    public FunctionTerm(String name, List<Term> arguments) {
        this.name = name;
        this.arguments = new ArrayList<>(arguments);
    }
    
    public String getName() {
        return name;
    }
    
    public List<Term> getArguments() {
        return new ArrayList<>(arguments);
    }
    
    public int getArity() {
        return arguments.size();
    }
    
    @Override
    public Set<String> getVariables() {
        Set<String> vars = new HashSet<>();
        for (Term arg : arguments) {
            vars.addAll(arg.getVariables());
        }
        return vars;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FunctionTerm)) return false;
        FunctionTerm other = (FunctionTerm) obj;
        return name.equals(other.name) && arguments.equals(other.arguments);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, arguments);
    }
    
    @Override
    public String toString() {
        if (arguments.isEmpty()) {
            return name + "()";
        }
        return name + "(" + 
            String.join(", ", 
                arguments.stream()
                .map(Term::toString)
                .toArray(String[]::new)) +
            ")";
    }
}
