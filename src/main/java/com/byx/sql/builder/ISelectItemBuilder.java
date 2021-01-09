package com.byx.sql.builder;

import com.byx.sql.Operand;
import com.byx.sql.SelectItem;

public interface ISelectItemBuilder
{
    interface AfterColumn extends SelectItem, Operand, IOperatorBuilder
    {
        AfterOf of(String tableName);
        AfterAs as(String alias);
    }

    interface AfterOf extends SelectItem, Operand, IOperatorBuilder
    {
        AfterAs as(String alias);
    }

    interface AfterAs extends SelectItem
    {

    }
}
