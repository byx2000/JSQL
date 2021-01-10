package com.byx.sql;

public class CalculateColumn implements SelectItem
{
    private final ArithExpr arithExpr;
    private final String alias;

    public CalculateColumn(ArithExpr arithExpr, String alias)
    {
        this.arithExpr = arithExpr;
        this.alias = alias;
    }

    @Override
    public String getSql()
    {
        String sql = arithExpr.getSql();
        if (alias != null) sql += " AS '" + alias + "'";
        return sql;
    }
}
