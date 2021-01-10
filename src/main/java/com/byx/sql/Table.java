package com.byx.sql;

public class Table implements FromItem, SqlComponent
{
    private final String tableName;
    private final String alias;

    public Table(String tableName, String alias)
    {
        this.tableName = tableName;
        this.alias = alias;
    }

    @Override
    public String getSql()
    {
        String sql = "`" + tableName + "`";
        if (alias != null) sql += " AS '" + alias + "'";
        return sql;
    }
}
