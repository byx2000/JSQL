package com.byx.sql;

public final class ColumnRef implements SelectItem, Aliasable
{
    private final String columnName;

    public ColumnRef(String columnName)
    {
        this.columnName = columnName;
    }

    @Override
    public String getSql()
    {
        return "`" + columnName + "`";
    }
}
