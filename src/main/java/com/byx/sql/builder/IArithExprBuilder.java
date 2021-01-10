package com.byx.sql.builder;

import com.byx.sql.ArithExpr;
import com.byx.sql.SelectItem;

public interface IArithExprBuilder extends ArithExpr, SelectItem
{
    IArithExprBuilder add(IArithExprBuilder arithExprBuilder);
    IArithExprBuilder sub(IArithExprBuilder arithExprBuilder);
    IConditionBuilder eq(IArithExprBuilder arithExprBuilder);
    IConditionBuilder gt(IArithExprBuilder arithExprBuilder);
    IConditionBuilder lt(IArithExprBuilder arithExprBuilder);
    ISelectItemBuilder as(String alias);
}
