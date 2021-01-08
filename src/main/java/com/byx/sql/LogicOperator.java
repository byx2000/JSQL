package com.byx.sql;

public class LogicOperator implements Condition
{
    private final Condition lhs, rhs;
    private final String op;

    public LogicOperator(Condition lhs, Condition rhs, String op)
    {
        this.lhs = lhs;
        this.rhs = rhs;
        this.op = op;
    }

    @Override
    public String getSql()
    {
        return String.format("(%s) %s (%s)", lhs.getSql(), op, rhs.getSql());
    }
}
