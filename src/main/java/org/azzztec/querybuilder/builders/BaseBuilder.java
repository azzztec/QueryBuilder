package org.azzztec.querybuilder.builders;

import org.azzztec.querybuilder.exeptions.RelationExeption;
import org.azzztec.querybuilder.exeptions.TypeNotSupported;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public abstract class BaseBuilder<T> extends ConditionBuilder<T>{
    protected String tableName;

    public BaseBuilder(String tableName) {
        this.tableName = tableName;
    }

    public abstract String build();

    protected abstract List<Object> getValues();

    protected abstract List<String> getKeys();

    public PreparedStatement prepare(final PreparedStatement prepared) throws TypeNotSupported, SQLException {
        List<Object> values = getValues();
        AtomicInteger inc = new AtomicInteger(1);
        for(int i = 0; i < values.size(); i++) {
            Object value = values.get(i);
            switch (value.getClass().getSimpleName()) {
                case "String":
                    prepared.setString(inc.get(), (String)value);
                    break;
                case "Boolean":
                    prepared.setBoolean(inc.get(), (Boolean)value);
                    break;
                case "Timestamp":
                    prepared.setString(inc.get(), value.toString());
                    break;
                case "Integer":
                    prepared.setInt(inc.get(), (Integer)value);
                    break;
                case "Short":
                    prepared.setShort(inc.get(), (Short)value);
                    break;
                case "Long":
                    prepared.setLong(inc.get(), (Long)value);
                    break;
                case "Double":
                    prepared.setDouble(inc.get(), (Double)value);
                    break;
                case "ArrayList":
                    inc.decrementAndGet();
                    for(Object val: (List<Object>)value) {
                        if (val instanceof String)
                            prepared.setString(inc.incrementAndGet(), (String)val);
                        if (val instanceof Integer)
                            prepared.setInt(inc.incrementAndGet(), (Integer)val);
                    }
                    break;
                default:
                    throw new TypeNotSupported(value.getClass().getSimpleName());
            }
            inc.incrementAndGet();
        }
        return prepared;
    }

    protected String joinRepeat(String delimiter, String value, int count) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < count; i++) {
            str.append(value);
            if(i != count - 1) {
                str.append(delimiter);
            }
        }
        return str.toString();
    }
}
