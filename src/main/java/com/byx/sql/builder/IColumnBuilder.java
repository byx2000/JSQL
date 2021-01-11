package com.byx.sql.builder;

import com.byx.sql.ArithExpr;

public interface IColumnBuilder extends ISelectItemBuilder
{
    interface AfterColumn extends ISelectItemBuilder, ArithExpr, IArithExprBuilder
    {
        AfterOf of(String tableName);
        AfterAs as(String alias);
    }

    interface AfterOf extends ISelectItemBuilder, ArithExpr, IArithExprBuilder
    {
        AfterAs as(String alias);
    }

    interface AfterAs extends ISelectItemBuilder
    {

    }
}
