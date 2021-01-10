package com.byx.sql.builder;

import com.byx.sql.ArithExpr;

public interface IArithExprBuilder extends ArithExpr
{
    IConditionBuilder eq(IArithExprBuilder arithExprBuilder);
    IConditionBuilder gt(IArithExprBuilder arithExprBuilder);
    IConditionBuilder lt(IArithExprBuilder arithExprBuilder);
}
