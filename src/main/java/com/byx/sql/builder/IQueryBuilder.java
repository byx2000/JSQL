package com.byx.sql.builder;

import com.byx.sql.Query;

public interface IQueryBuilder extends Query, IFromItemBuilder.AfterTable
{
    interface AfterSelect
    {
        AfterFrom from(IFromItemBuilder... fromItemBuilders);
    }

    interface AfterFrom extends IQueryBuilder
    {
        AfterWhere where(IConditionBuilder conditionBuilder);
    }

    interface AfterWhere extends IQueryBuilder
    {

    }
}
