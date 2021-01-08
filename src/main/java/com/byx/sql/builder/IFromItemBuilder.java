package com.byx.sql.builder;

import com.byx.sql.FromItem;

public interface IFromItemBuilder
{
    interface CanAs extends FromItem
    {
        FromItem as(String alias);
    }
}
