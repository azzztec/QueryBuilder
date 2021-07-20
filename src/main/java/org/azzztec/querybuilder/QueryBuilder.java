package org.azzztec.querybuilder;

import org.azzztec.querybuilder.builders.DeleteBuilder;
import org.azzztec.querybuilder.builders.InsertBuilder;
import org.azzztec.querybuilder.builders.SelectBuilder;
import org.azzztec.querybuilder.builders.UpdateBuilder;

public class QueryBuilder {
    public static InsertBuilder insert(String tableName) {
        return new InsertBuilder(tableName);
    }

    public static SelectBuilder select(String tableName) {
        return new SelectBuilder(tableName);
    }

    public static DeleteBuilder delete(String tableName) {
        return new DeleteBuilder(tableName);
    }

    public static UpdateBuilder update(String tableName) {
        return new UpdateBuilder(tableName);
    }
}
