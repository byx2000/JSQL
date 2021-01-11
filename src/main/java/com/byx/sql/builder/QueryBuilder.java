package com.byx.sql.builder;

import com.byx.sql.Condition;
import com.byx.sql.FromItem;
import com.byx.sql.Select;
import com.byx.sql.SelectItem;

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

    @Override
    public String getSql()
    {
        return new Select(selectItems, fromItems, condition).getSql();
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
}
