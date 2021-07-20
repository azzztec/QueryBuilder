package org.azzztec.querybuilder.builders;

import org.azzztec.querybuilder.exeptions.RelationExeption;
import org.azzztec.querybuilder.types.Condition;
import org.azzztec.querybuilder.types.LogicOperator;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConditionBuilder<T> {
    private List<Triplet<String, Object, Condition>> conditions = new ArrayList<>();
    private Queue<LogicOperator> logicOperators = new LinkedList<>();

    public T where(String key, Object value, Condition condition) {
        conditions.add(new Triplet(key, value, condition));
        return (T) this;
    }

    public T and() {
        logicOperators.add(LogicOperator.AND);
        return (T) this;
    }

    public T or() {
        logicOperators.add(LogicOperator.OR);
        return (T) this;
    }

    protected String buildCondition() {
        Triplet<String, Object, Condition> tripl;
        StringBuilder res = new StringBuilder("");
        if(!conditions.isEmpty()) {
            try {
                if(logicOperators.size() == conditions.size() - 1 || logicOperators.isEmpty()) {
                    res.append(" WHERE");
                    for (int i = 0; i < conditions.size(); i++) {
                        tripl = conditions.get(i);
                        res.append(" " + tripl.getValue0() + tripl.getValue2().getCharacter() + "'" + tripl.getValue1() + "'");
                        if (!logicOperators.isEmpty()) {
                            res.append(" " + logicOperators.poll() + " ");
                        }
                    }
                } else {
                    throw new RelationExeption("Number of logic operators must be less by one");
                }
            } catch (RelationExeption e) {
                System.out.println(e);
            }
        }

        return res.append(";").toString();
    }
}
