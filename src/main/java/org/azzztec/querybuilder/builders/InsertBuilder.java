package org.azzztec.querybuilder.builders;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InsertBuilder extends BaseBuilder<InsertBuilder>{
    private List<Pair<String, Object>> queryParams = new ArrayList<>();

    public InsertBuilder(String tableName) {
        super(tableName);
    }

    public InsertBuilder addValue(String key, Object value) {
        this.queryParams.add(new Pair(key, value));
        return this;
    }

    @Override
    public String build() {
        StringBuilder res = new StringBuilder();
        List<String> keys = this.getKeys();
        List<Object> values = this.getValues();
        res
            .append("INSERT INTO " + tableName + " ")
            .append("(" + String.join(", ", keys) + ") ")
            .append("VALUES ")
            .append("(" + joinRepeat(", ", "?", values.size()) + ")")
            .append(buildCondition());
        return res.toString();
    }

    @Override
    public List<Object> getValues() {
        return this.queryParams.stream().map(pair -> pair.getValue1()).collect(Collectors.toList());
    }

    @Override
    public List<String> getKeys() {
        return this.queryParams.stream().map(pair -> pair.getValue0()).collect(Collectors.toList());
    }
}
