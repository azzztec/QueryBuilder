package org.azzztec.querybuilder.builders;

import org.azzztec.querybuilder.types.Condition;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateBuilder extends BaseBuilder<UpdateBuilder> {
    private List<Triplet<String, Object, Condition>> queryParams = new ArrayList<>();

    public UpdateBuilder(String tableName) {
        super(tableName);
    }

    public UpdateBuilder addValue(String key, Object value, Condition condition) {
        this.queryParams.add(new Triplet(key, value, condition));
        return this;
    }

    @Override
    public String build() {
        Triplet<String, Object, Condition> tripl;
        StringBuilder res = new StringBuilder();
        res.append("UPDATE " + tableName + " SET ");
        for(int i = 0; i < queryParams.size(); i++) {
            tripl = queryParams.get(i);
            res.append(tripl.getValue0() + tripl.getValue2().getCharacter() + "?");
        }
        res.append(buildCondition());
        return res.toString();
    }

    @Override
    protected List<Object> getValues() {
        return this.queryParams.stream().map(tripl -> tripl.getValue1()).collect(Collectors.toList());
    }

    @Override
    protected List<String> getKeys() {
        return this.queryParams.stream().map(tripl -> tripl.getValue0()).collect(Collectors.toList());
    }
}
