package com.byx.sql.builder;

import com.byx.sql.Condition;

public interface IConditionBuilder extends Condition
{
    IConditionBuilder and(IConditionBuilder conditionBuilder);
    IConditionBuilder or(IConditionBuilder conditionBuilder);
}
