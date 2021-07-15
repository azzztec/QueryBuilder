package org.azzztec.querybuilder.builders;

import org.azzztec.querybuilder.types.Condition;
import org.javatuples.Triplet;

public interface Modifiable<T> {
    public T addValue(String key, Object value);
}
