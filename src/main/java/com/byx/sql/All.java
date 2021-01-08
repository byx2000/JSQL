package com.byx.sql;

public class All implements SelectItem
{
    @Override
    public String getSql()
    {
        return "*";
    }
}
