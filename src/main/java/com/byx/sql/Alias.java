package com.byx.sql;

public class Alias implements SelectItem
{
    private final Aliasable aliasable;
    private final String alias;

    public Alias(Aliasable aliasable, String alias)
    {
        this.aliasable = aliasable;
        this.alias = alias;
    }

    @Override
    public String getSql()
    {
        return String.format("%s AS %s", aliasable.getSql(), alias);
    }
}
