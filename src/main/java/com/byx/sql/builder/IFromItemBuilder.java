package com.byx.sql.builder;

import com.byx.sql.FromItem;

public interface IFromItemBuilder
{
    interface AfterTable extends FromItem
    {
        AfterAs as(String alias);
    }

    interface AfterAs extends FromItem
    {

    }
}
