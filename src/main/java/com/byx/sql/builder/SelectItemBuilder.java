package com.byx.sql.builder;

import com.byx.sql.Alias;
import com.byx.sql.ColumnRef;
import com.byx.sql.SelectItem;

public class SelectItemBuilder implements CanColumn, CanAs
{
    private ColumnRef columnRef;
    private Alias alias;

    @Override
    public String getSql()
    {
        if (alias != null) return alias.getSql();
        return columnRef.getSql();
    }

    @Override
    public CanAs column(String columnName)
    {
        columnRef = new ColumnRef(columnName);
        return this;
    }

    @Override
    public SelectItem as(String name)
    {
        alias = new Alias(columnRef, name);
        return this;
    }
}
