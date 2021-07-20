package org.azzztec.querybuilder.builders;

import java.util.List;

public class DeleteBuilder extends BaseBuilder<DeleteBuilder>{

    public DeleteBuilder(String tableName) {
        super(tableName);
    }

    @Override
    public String build() {
        StringBuilder res = new StringBuilder("DELETE FROM ");
        res
            .append(tableName)
            .append(buildCondition());
        return res.toString();
    }

    @Override
    protected List<Object> getValues() {
        return null;
    }

    @Override
    protected List<String> getKeys() {
        return null;
    }
}
