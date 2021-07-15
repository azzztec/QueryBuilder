package org.azzztec.querybuilder;

import org.azzztec.querybuilder.builders.InsertBuilder;

public class QueryBuilder {
    public static InsertBuilder insert(String tableName) {
        return new InsertBuilder(tableName);
    }
}
