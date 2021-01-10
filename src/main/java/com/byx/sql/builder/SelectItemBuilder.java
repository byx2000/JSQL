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
    public IConditionBuilder eq(IArithExprBuilder arithExprBuilder)
    {
        return new ConditionBuilder(new CompareOperator(this, arithExprBuilder, "="));
    }

    @Override
    public IConditionBuilder gt(IArithExprBuilder arithExprBuilder)
    {
        return new ConditionBuilder(new CompareOperator(this, arithExprBuilder, ">"));
    }

    @Override
    public IConditionBuilder lt(IArithExprBuilder arithExprBuilder)
    {
        return new ConditionBuilder(new CompareOperator(this, arithExprBuilder, "<"));
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
