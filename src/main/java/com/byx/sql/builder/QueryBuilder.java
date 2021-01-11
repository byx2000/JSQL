package com.byx.sql.builder;

import com.byx.sql.*;

import java.util.Arrays;
import java.util.List;

public class QueryBuilder implements IQueryBuilder, IQueryBuilder.AfterSelect, IQueryBuilder.AfterFrom, IQueryBuilder.AfterWhere
{
    private final List<SelectItem> selectItems;
    private List<FromItem> fromItems;
    private Condition condition;

    public QueryBuilder(List<SelectItem> selectItems)
    {
        this.selectItems = selectItems;
    }

    private Query buildQuery()
    {
        return new Select(selectItems, fromItems, condition);
    }

    @Override
    public String getSql()
    {
        return buildQuery().getSql();
    }

    @Override
    public AfterFrom from(IFromItemBuilder... fromItemBuilders)
    {
        this.fromItems = Arrays.asList(fromItemBuilders);
        return this;
    }

    @Override
    public AfterWhere where(IConditionBuilder conditionBuilder)
    {
        this.condition = conditionBuilder;
        return this;
    }

    @Override
    public SelectItemBuilderAndFromItemBuilder as(String alias)
    {
        return () -> new SubQuery(buildQuery(), alias).getSql();
    }

//    @Override
//    public AfterAs as(String alias)
//    {
//        return () -> new QueryTable(buildQuery(), alias).getSql();
//    }
}
