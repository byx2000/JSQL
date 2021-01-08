package com.byx.sql;

public class TableRef implements FromItem, Aliasable
{
    private final String tableName;

    public TableRef(String tableName)
    {
        this.tableName = tableName;
    }

    @Override
    public String getSql()
    {
        return "`" + tableName + "`";
    }
}
