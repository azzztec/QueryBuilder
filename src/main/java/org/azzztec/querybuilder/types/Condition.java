package org.azzztec.querybuilder.types;

import lombok.Getter;
import lombok.Setter;

public enum Condition {
    EQUAL("="),
    NOTEQUAL("!="),
    SUPERIOR(">"),
    SUPERIOR_EQUAL(">="),
    INFERIOR("<"),
    INFERIOR_EQUAL("<="),
    IN("IN"),
    NOTIN("NOT IN"),
    LIKE("LIKE");

    @Getter
    private String character;

    private Condition(String character) {
        this.character = character;
    }

}
