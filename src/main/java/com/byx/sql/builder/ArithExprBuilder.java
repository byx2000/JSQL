package com.byx.sql.builder;

import com.byx.sql.*;

public class ArithExprBuilder implements IArithExprBuilder
{
    private final ArithExpr arithExpr;

    public ArithExprBuilder(ArithExpr arithExpr)
    {
        this.arithExpr = arithExpr;
    }

    @Override
    public String getSql()
    {
        return arithExpr.getSql();
    }

    @Override
    public IArithExprBuilder add(IArithExprBuilder arithExprBuilder)
    {
        return new ArithExprBuilder(new ArithOperator(arithExpr, arithExprBuilder, "+"));
    }

    @Override
    public IArithExprBuilder sub(IArithExprBuilder arithExprBuilder)
    {
        return new ArithExprBuilder(new ArithOperator(arithExpr, arithExprBuilder, "-"));
    }

    @Override
    public IConditionBuilder eq(IArithExprBuilder arithExprBuilder)
    {
        return new ConditionBuilder(new CompareOperator(arithExpr, arithExprBuilder, "="));
    }

    @Override
    public IConditionBuilder gt(IArithExprBuilder arithExprBuilder)
    {
        return new ConditionBuilder(new CompareOperator(arithExpr, arithExprBuilder, ">"));
    }

    @Override
    public IConditionBuilder lt(IArithExprBuilder arithExprBuilder)
    {
        return new ConditionBuilder(new CompareOperator(arithExpr, arithExprBuilder, "<"));
    }

    @Override
    public SelectItem as(String alias)
    {
        return () -> new CalculateColumn(arithExpr, alias).getSql();
    }
}
