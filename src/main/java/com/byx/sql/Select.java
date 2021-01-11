package com.byx.sql;

import java.util.List;

public final class Select implements Query
{
    private final List<SelectItem> selectItems;
    private final List<FromItem> fromItems;
    private final Condition condition;

    public Select(List<SelectItem> selectItems, List<FromItem> fromItems, Condition condition)
    {
        this.selectItems = selectItems;
        this.fromItems = fromItems;
        this.condition = condition;
    }

    @Override
    public String getSql()
    {
        StringBuilder sql = new StringBuilder("SELECT ");
        if (selectItems != null && !selectItems.isEmpty())
        {
            for (int i = 0; i < selectItems.size(); ++i)
            {
                sql.append(selectItems.get(i).getSql());
                if (i != selectItems.size() - 1) sql.append(", ");
            }
        }

        if (fromItems != null && !fromItems.isEmpty())
        {
            sql.append(" FROM ");
            for (int i = 0; i < fromItems.size(); ++i)
            {
                if (fromItems.get(i) instanceof Query)
                    sql.append("(").append(fromItems.get(i).getSql()).append(")");
                else
                    sql.append(fromItems.get(i).getSql());
                if (i != fromItems.size() - 1) sql.append(", ");
            }
        }

        if (condition != null)
        {
            sql.append(" WHERE ").append(condition.getSql());
        }

        return sql.toString();
    }
}
