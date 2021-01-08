package com.byx.sql.builder;

import com.byx.sql.All;
import com.byx.sql.SelectItem;

public class Sql
{
    public static ISelectItemBuilder.CanAs column(String columnName)
    {
        return new SelectItemBuilder(columnName);
    }

    public static SelectItem all()
    {
        return new All();
    }
}
