package common;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parameter extends Term {
    private final String text;
    private static final Pattern VARIABLE_PATTERN = Pattern.compile("[A-Z][A-Z0-9_]*");

    public Parameter(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    
    @Override
    public Set<String> getVariables() {
        Set<String> vars = new HashSet<>();
        Matcher matcher = VARIABLE_PATTERN.matcher(text);
        while (matcher.find()) {
            vars.add(matcher.group());
        }
        return vars;
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
