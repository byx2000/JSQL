package com.byx.sql.builder;

import com.byx.sql.*;

public final class ColumnBuilder implements IColumnBuilder, IColumnBuilder.AfterColumn, IColumnBuilder.AfterOf, IColumnBuilder.AfterAs
{
    private final String columnName;
    private String tableName;
    private String alias;

    public ColumnBuilder(String columnName)
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
    public IArithExprBuilder add(IArithExprBuilder arithExprBuilder)
    {
        return new ArithExprBuilder(new ArithOperator(buildColumn(), arithExprBuilder, "+"));
    }

    @Override
    public IArithExprBuilder sub(IArithExprBuilder arithExprBuilder)
    {
        return new ArithExprBuilder(new ArithOperator(buildColumn(), arithExprBuilder, "-"));
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
    public IColumnBuilder.AfterOf of(String tableName)
    {
        this.tableName = tableName;
        return this;
    }

    @Override
    public IColumnBuilder.AfterAs as(String alias)
    {
        this.alias = alias;
        return this;
    }
}
