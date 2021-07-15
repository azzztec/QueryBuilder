package org.azzztec.querybuilder.types;

import lombok.Getter;
import lombok.Setter;

public enum Condition {
    EQUAL("=", LogicOperator.NONE),
    NOTEQUAL("!=", LogicOperator.NONE),
    SUPERIOR(">", LogicOperator.NONE),
    SUPERIOR_EQUAL(">=", LogicOperator.NONE),
    INFERIOR("<", LogicOperator.NONE),
    INFERIOR_EQUAL("<=", LogicOperator.NONE),
    IN("IN", LogicOperator.NONE),
    NOTIN("NOT IN", LogicOperator.NONE),
    LIKE("LIKE", LogicOperator.NONE);

    @Getter
    private String character;

    @Getter
    @Setter
    private LogicOperator logicOperator = LogicOperator.NONE;

    private Condition(String character, LogicOperator logicOperator) {
        this.character = character;
        this.logicOperator = logicOperator;
    }

}
