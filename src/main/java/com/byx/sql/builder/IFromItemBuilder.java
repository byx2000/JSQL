package com.byx.sql.builder;

import com.byx.sql.FromItem;

public interface IFromItemBuilder extends FromItem
{
    interface AfterTable extends IFromItemBuilder
    {
        AfterAs as(String alias);
    }

    interface AfterAs extends IFromItemBuilder
    {

    }
}
