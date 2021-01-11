package com.byx.sql.builder;

import com.byx.sql.Query;

public interface IQueryBuilder extends Query
{
    interface AfterSelect
    {
        AfterFrom from(IFromItemBuilder... fromItemBuilders);
    }

    interface AfterFrom extends Query
    {
        AfterWhere where(IConditionBuilder conditionBuilder);
    }

    interface AfterWhere extends Query
    {

    }
}
