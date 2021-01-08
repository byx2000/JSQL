package com.byx.sql;

public class ArithOperator implements Condition
{
    private final Operand lhs, rhs;
    private final String op;

    public ArithOperator(Operand lhs, Operand rhs, String op)
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
