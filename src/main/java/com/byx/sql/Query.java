package com.byx.sql;

import java.util.List;

public final class Query implements SqlComponent
{
    private final List<SelectItem> select;
    private final FromItem from;
    private final Condition condition;

    public Query(List<SelectItem> select, FromItem from, Condition condition)
    {
        this.select = select;
        this.from = from;
        this.condition = condition;
    }

    @Override
    public String getSql()
    {
        return null;
    }
}
