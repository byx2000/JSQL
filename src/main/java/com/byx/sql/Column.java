package com.byx.sql;

public final class Column implements SelectItem, Operand, SqlComponent
{
    private final String columnName;
    private final String tableName;
    private final String alias;

    public Column(String columnName, String tableName, String alias)
    {
        this.columnName = columnName;
        this.tableName = tableName;
        this.alias = alias;
    }

    @Override
    public String getSql()
    {
        String sql = "`" + columnName + "`";
        if (tableName != null) sql = "`" + tableName + "`." + sql;
        if (alias != null) sql += " AS '" + alias + "'";
        return sql;
    }
}
