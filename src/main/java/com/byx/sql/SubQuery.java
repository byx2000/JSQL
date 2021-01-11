package com.byx.sql;

public final class SubQuery implements SelectItem, FromItem
{
    private final Query query;
    private final String alias;

    public SubQuery(Query query, String alias)
    {
        this.query = query;
        this.alias = alias;
    }

    @Override
    public String getSql()
    {
        String sql = "(" + query.getSql() + ")";
        if (alias != null) sql += " AS '" + alias + "'";
        return sql;
    }
}
