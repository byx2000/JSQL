package com.byx.sql;

public final class Literal<T> implements Operand
{
    private final T value;

    public Literal(T value)
    {
        this.value = value;
    }

    @Override
    public String getSql()
    {
        if (value instanceof String || value instanceof Character)
            return "'" + value + "'";
        return value.toString();
    }
}
