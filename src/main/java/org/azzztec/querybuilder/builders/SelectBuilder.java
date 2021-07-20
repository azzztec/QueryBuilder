package org.azzztec.querybuilder.builders;

import org.azzztec.querybuilder.exeptions.RelationExeption;

import java.util.List;

public class SelectBuilder extends BaseBuilder<SelectBuilder>{

    public SelectBuilder(String tableName) {
        super(tableName);
    }

    @Override
    public String build() {
        StringBuilder res = new StringBuilder("SELECT * FROM ");
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
