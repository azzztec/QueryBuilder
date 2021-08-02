package org.azzztec.querybuilder.types;

import lombok.Getter;

public enum Predicate {
    AND("AND"),
    OR("OR"),
    NONE("");

    @Getter
    final private String operator;

    private Predicate(String operator) {
        this.operator = operator;
    }
}
