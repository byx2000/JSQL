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
    public IConditionBuilder eq(IArithExprBuilder operatorBuilder)
    {
        return new ConditionBuilder(new ArithOperator(arithExpr, operatorBuilder, "="));
    }
}
