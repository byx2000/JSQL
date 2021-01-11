package com.byx.sql.builder;

import com.byx.sql.Query;

public interface IQueryBuilder extends Query
{
    interface SelectItemBuilderAndFromItemBuilder extends ISelectItemBuilder, IFromItemBuilder
    {

    }

    interface AfterSelect
    {
        AfterFrom from(IFromItemBuilder... fromItemBuilders);
    }

    interface AfterFrom extends IQueryBuilder, SelectItemBuilderAndFromItemBuilder
    {
        AfterWhere where(IConditionBuilder conditionBuilder);
        SelectItemBuilderAndFromItemBuilder as(String alias);
    }

    interface AfterWhere extends IQueryBuilder, SelectItemBuilderAndFromItemBuilder
    {
        SelectItemBuilderAndFromItemBuilder as(String alias);
    }
}
