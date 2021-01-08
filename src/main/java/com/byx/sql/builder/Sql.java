package com.byx.sql.builder;

import com.byx.sql.All;
import com.byx.sql.SelectItem;

public class Sql
{
    public static CanAs column(String columnName)
    {
        return new SelectItemBuilder().column(columnName);
    }

    public static SelectItem all()
    {
        return new All();
    }
}
