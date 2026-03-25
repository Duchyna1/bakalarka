package common;

import java.util.*;

public class Constant extends Term {
    private final String value;
    
    public Constant(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public Set<String> getVariables() {
        return new HashSet<>();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Constant)) return false;
        Constant other = (Constant) obj;
        return value.equals(other.value);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    
    @Override
    public String toString() {
        return value;
    }
}
