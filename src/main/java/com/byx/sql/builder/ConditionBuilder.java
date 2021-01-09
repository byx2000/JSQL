package com.byx.sql.builder;

import com.byx.sql.Condition;
import com.byx.sql.LogicOperator;

public class ConditionBuilder implements IConditionBuilder
{
    private final Condition condition;

    public ConditionBuilder(Condition condition)
    {
        this.condition = condition;
    }

    @Override
    public String getSql()
    {
        return condition.getSql();
    }

    @Override
    public IConditionBuilder and(IConditionBuilder conditionBuilder)
    {
        return new ConditionBuilder(new LogicOperator(condition, conditionBuilder, "AND"));
    }

    @Override
    public IConditionBuilder or(IConditionBuilder conditionBuilder)
    {
        return new ConditionBuilder(new LogicOperator(condition, conditionBuilder, "OR"));
    }
}
