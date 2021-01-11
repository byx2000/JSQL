package com.byx.sql.builder;

import com.byx.sql.All;
import com.byx.sql.Literal;

import java.util.Arrays;

public class Sql
{
    public static IColumnBuilder.AfterColumn column(String columnName)
    {
        return new ColumnBuilder(columnName);
    }

    public static ISelectItemBuilder all()
    {
        return () -> new All().getSql();
    }

    public static IFromItemBuilder.AfterTable table(String tableName)
    {
        return new FromItemBuilder(tableName);
    }

    public static <T> ArithExprBuilder literal(T value)
    {
        return new ArithExprBuilder(new Literal<>(value));
    }

    public static IQueryBuilder.AfterSelect select(ISelectItemBuilder... selectItemBuilders)
    {
        return new QueryBuilder(Arrays.asList(selectItemBuilders));
    }
}
