package common;

import java.util.*;

public abstract class Term {
    public abstract Set<String> getVariables();
    
    @Override
    public abstract String toString();
    
    @Override
    public abstract boolean equals(Object obj);
}
