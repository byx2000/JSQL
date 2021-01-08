package com.byx.sql.builder;

import com.byx.sql.Alias;
import com.byx.sql.ColumnRef;
import com.byx.sql.SelectItem;

public class SelectItemBuilder implements ISelectItemBuilder.CanAs
{
    private final ColumnRef columnRef;
    private Alias alias;

    public SelectItemBuilder(String columnName)
    {
        columnRef = new ColumnRef(columnName);
    }

    @Override
        public SelectItem as(String name)
        {
            alias = new Alias(columnRef, name);
        return this;
    }

    @Override
    public String getSql()
    {
        if (alias != null) return alias.getSql();
        return columnRef.getSql();
    }
}
