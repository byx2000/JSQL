package com.byx.sql.builder;

import com.byx.sql.ArithExpr;
import com.byx.sql.SelectItem;

public interface IColumnBuilder extends SelectItem
{
    interface AfterColumn extends SelectItem, ArithExpr, IArithExprBuilder
    {
        AfterOf of(String tableName);
        AfterAs as(String alias);
    }

    interface AfterOf extends SelectItem, ArithExpr, IArithExprBuilder
    {
        AfterAs as(String alias);
    }

    interface AfterAs extends SelectItem
    {

    }
}
