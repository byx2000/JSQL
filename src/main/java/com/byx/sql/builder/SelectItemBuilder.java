package com.byx.sql.builder;

import com.byx.sql.*;

public final class SelectItemBuilder implements ISelectItemBuilder.AfterColumn, ISelectItemBuilder.AfterOf, ISelectItemBuilder.AfterAs
{
    private final String columnName;
    private String tableName;
    private String alias;

    public SelectItemBuilder(String columnName)
    {
        this.columnName = columnName;
    }

    private Column buildColumn()
    {
        return new Column(columnName, tableName, alias);
    }

    @Override
    public String getSql()
    {
        return buildColumn().getSql();
    }

    @Override
    public IConditionBuilder eq(IArithExprBuilder operatorBuilder)
    {
        return new ConditionBuilder(new ArithOperator(buildColumn(), operatorBuilder, "="));
    }

    @Override
    public ISelectItemBuilder.AfterOf of(String tableName)
    {
        this.tableName = tableName;
        return this;
    }

    @Override
    public ISelectItemBuilder.AfterAs as(String alias)
    {
        this.alias = alias;
        return this;
    }
}
