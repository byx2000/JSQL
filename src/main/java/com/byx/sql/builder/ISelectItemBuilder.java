package com.byx.sql.builder;

import com.byx.sql.SelectItem;

public interface ISelectItemBuilder
{
    interface CanAs extends SelectItem
    {
        SelectItem as(String alias);
    }
}
