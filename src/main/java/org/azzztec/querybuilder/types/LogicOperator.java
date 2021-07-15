package org.azzztec.querybuilder.types;

import lombok.Getter;

public enum LogicOperator {
    AND("AND"),
    OR("OR"),
    NONE("");

    @Getter
    final private String operator;

    private LogicOperator(String operator) {
        this.operator = operator;
    }
}
