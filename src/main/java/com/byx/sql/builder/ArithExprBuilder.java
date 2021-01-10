package com.byx.sql.builder;

import com.byx.sql.ArithOperator;
import com.byx.sql.ArithExpr;

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
    public IConditionBuilder eq(IArithExprBuilder arithExprBuilder)
    {
        return new ConditionBuilder(new ArithOperator(arithExpr, arithExprBuilder, "="));
    }

    @Override
    public IConditionBuilder gt(IArithExprBuilder arithExprBuilder)
    {
        return new ConditionBuilder(new ArithOperator(arithExpr, arithExprBuilder, ">"));
    }

    @Override
    public IConditionBuilder lt(IArithExprBuilder arithExprBuilder)
    {
        return new ConditionBuilder(new ArithOperator(arithExpr, arithExprBuilder, "<"));
    }
}
