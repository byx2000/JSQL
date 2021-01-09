package com.byx.sql;

public final class ColumnOfTable implements SelectItem, Operand
{
    private final String tableName;
    private final String columnName;

    public ColumnOfTable(String tableName, String columnName)
    {
        this.tableName = tableName;
        this.columnName = columnName;
    }

    @Override
    public String getSql()
    {
        return String.format("`%s`.`%s`", tableName, columnName);
    }
}
