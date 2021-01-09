package com.byx.sql.builder;

import com.byx.sql.ArithOperator;
import com.byx.sql.Operand;

public class OperandBuilder implements IOperatorBuilder
{
    private final Operand operand;

    public OperandBuilder(Operand operand)
    {
        this.operand = operand;
    }

    @Override
    public String getSql()
    {
        return operand.getSql();
    }

    @Override
    public IConditionBuilder eq(IOperatorBuilder operatorBuilder)
    {
        return new ConditionBuilder(new ArithOperator(operand, operatorBuilder, "="));
    }
}
