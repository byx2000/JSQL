package com.byx.sql.builder;

import com.byx.sql.Operand;

public interface IOperatorBuilder extends Operand
{
    IConditionBuilder eq(IOperatorBuilder operatorBuilder);
}
