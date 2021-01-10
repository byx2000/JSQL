package com.byx.sql.builder;

import com.byx.sql.ArithExpr;

public interface IArithExprBuilder extends ArithExpr
{
    IConditionBuilder eq(IArithExprBuilder operatorBuilder);
}
