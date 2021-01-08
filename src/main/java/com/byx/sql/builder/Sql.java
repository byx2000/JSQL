package com.byx.sql.builder;

public class Sql
{
    public static CanAs column(String columnName)
    {
        return new SelectItemBuilder().column(columnName);
    }
}
