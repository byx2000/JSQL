package com.byx.sql.builder;

import com.byx.sql.Alias;
import com.byx.sql.FromItem;
import com.byx.sql.TableRef;

public class FromItemBuilder implements IFromItemBuilder.CanAs
{
    private final TableRef tableRef;
    private Alias alias;

    public FromItemBuilder(String tableName)
    {
        tableRef = new TableRef(tableName);
    }

    @Override
    public String getSql()
    {
        if (alias != null) return alias.getSql();
        return tableRef.getSql();
    }

    @Override
    public FromItem as(String name)
    {
        alias = new Alias(tableRef, name);
        return this;
    }
}
