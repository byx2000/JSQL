package com.byx.sql.builder;

import com.byx.sql.All;
import com.byx.sql.Literal;
import com.byx.sql.SelectItem;

public class Sql
{
    public static ISelectItemBuilder.AfterColumn column(String columnName)
    {
        return new SelectItemBuilder(columnName);
    }

    public static SelectItem all()
    {
        return new All();
    }

    public static IFromItemBuilder.AfterTable table(String tableName)
    {
        return new FromItemBuilder(tableName);
    }

    public static <T> ArithExprBuilder literal(T value)
    {
        return new ArithExprBuilder(new Literal<>(value));
    }
}
