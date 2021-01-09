package com.byx.sql.builder;

import com.byx.sql.Table;

public class FromItemBuilder implements IFromItemBuilder.AfterTable, IFromItemBuilder.AfterAs
{
    private final String tableName;
    private String alias;

    public FromItemBuilder(String tableName)
    {
        this.tableName = tableName;
    }

    @Override
    public String getSql()
    {
        return new Table(tableName, alias).getSql();
    }

    @Override
    public IFromItemBuilder.AfterAs as(String alias)
    {
        this.alias = alias;
        return this;
    }
}
