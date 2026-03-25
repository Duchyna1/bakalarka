package datalog;

import java.util.*;
import java.util.stream.Collectors;

public class Clause {
    private final Predicate head;
    private final List<Atom> body;
    
    public Clause(Predicate head, List<Atom> body) {
        this.head = head;
        this.body = new ArrayList<>(body);
    }
    
    public Predicate getHead() {
        return head;
    }
    
    public List<Atom> getBody() {
        return new ArrayList<>(body);
    }
    
    public Set<String> getVariables() {
        Set<String> vars = new HashSet<>(head.getVariables());
        for (Atom atom : body) {
            vars.addAll(atom.getVariables());
        }
        return vars;
    }
    
    public String isSafe() {
        Set<String> headVars = head.getVariables();
        Set<String> bodyPositiveVars = new HashSet<>();
        Set<String> bodyNegativeVars = new HashSet<>();
        for (Atom atom : body) {
            if (atom.isNegated()) {
                bodyNegativeVars.addAll(atom.getVariables());
            } else {
                bodyPositiveVars.addAll(atom.getVariables());
            }
        }
        
        if (bodyPositiveVars.size() == 0) {
            return "No positive atoms in body";
        }
        
        for (String var : headVars) {
            if (!bodyPositiveVars.contains(var) && !bodyNegativeVars.contains(var)) {
                return "Variable in head not in body";
            }
        }
        
        for (String var : bodyNegativeVars) {
            if (!bodyPositiveVars.contains(var)) {
                return "Variable in negated atom not in positive atom";
            }
        }
        
        return null;
    }
    
    @Override
    public String toString() {
        return head + " :- " + body.stream()
        .map(Atom::toString)
        .collect(Collectors.joining(", "))
        + ".";
    }
}
