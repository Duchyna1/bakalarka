package common;

import java.util.*;

public class Parameter extends Term {
    private final String text;

    public Parameter(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public Set<String> getVariables() {
        return new HashSet<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Parameter)) return false;
        Parameter other = (Parameter) obj;
        return text.equals(other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return text;
    }
}
