package com.byx.sql.builder;

import com.byx.sql.ArithExpr;

public interface IArithExprBuilder extends ArithExpr
{
    IArithExprBuilder add(IArithExprBuilder arithExprBuilder);
    IArithExprBuilder sub(IArithExprBuilder arithExprBuilder);
    IConditionBuilder eq(IArithExprBuilder arithExprBuilder);
    IConditionBuilder gt(IArithExprBuilder arithExprBuilder);
    IConditionBuilder lt(IArithExprBuilder arithExprBuilder);
}
