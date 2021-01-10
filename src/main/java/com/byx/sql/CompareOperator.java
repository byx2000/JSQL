package com.byx.sql;

public class CompareOperator implements Condition
{
    private final ArithExpr lhs, rhs;
    private final String op;

    public CompareOperator(ArithExpr lhs, ArithExpr rhs, String op)
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
