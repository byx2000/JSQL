package com.byx;

import com.byx.sql.Condition;
import com.byx.sql.FromItem;
import com.byx.sql.ArithExpr;
import com.byx.sql.SelectItem;
import org.junit.jupiter.api.Test;

import static com.byx.sql.builder.Sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest
{
    @Test
    public void testSelectItem()
    {
        SelectItem item1 = column("name");
        assertEquals("`name`", item1.getSql());
        SelectItem item2 = column("name").as("n");
        assertEquals("`name` AS 'n'", item2.getSql());
        SelectItem item3 = column("name").of("b");
        assertEquals("`b`.`name`", item3.getSql());
        SelectItem item4 = column("name").of("b").as("n");
        assertEquals("`b`.`name` AS 'n'", item4.getSql());
        SelectItem item5 = all();
        assertEquals("*", item5.getSql());
    }

    @Test
    public void testFromItem()
    {
        FromItem item1 = table("users");
        assertEquals("`users`", item1.getSql());
        FromItem item2 = table("users").as("u");
        assertEquals("`users` AS `u`", item2.getSql());
    }

    @Test
    public void testOperand()
    {
        ArithExpr e1 = column("name");
        assertEquals("`name`", e1.getSql());
        ArithExpr e2 = column("name").of("b");
        assertEquals("`b`.`name`", e2.getSql());
        ArithExpr e3 = literal(123);
        assertEquals("123", e3.getSql());
        ArithExpr e4 = literal("byx");
        assertEquals("'byx'", e4.getSql());
        ArithExpr e5 = literal('a');
        assertEquals("'a'", e5.getSql());
        ArithExpr e6 = literal(3.14);
        assertEquals("3.14", e6.getSql());
    }

    @Test
    public void testCondition()
    {
        Condition c1 = column("name").eq(literal(12));
        assertEquals("(`name`) = (12)", c1.getSql());
        Condition c2 = column("name").of("b").eq(literal("byx"));
        assertEquals("(`b`.`name`) = ('byx')", c2.getSql());
        Condition c3 = column("id").eq(literal(1001)).and(column("name").eq(literal("byx")));
        assertEquals("((`id`) = (1001)) AND ((`name`) = ('byx'))", c3.getSql());
        Condition c4 = column("id").eq(literal(1001)).or(column("name").eq(literal("byx")));
        assertEquals("((`id`) = (1001)) OR ((`name`) = ('byx'))", c4.getSql());
        Condition c5 = column("id").of("u").eq(literal(1001)).and(column("name").of("b").eq(literal("byx")));
        assertEquals("((`u`.`id`) = (1001)) AND ((`b`.`name`) = ('byx'))", c5.getSql());
        Condition c6 = column("id").eq(literal(1001)).and(column("name").eq(literal("byx"))).or(column("gender").eq(literal('F')));
        assertEquals("(((`id`) = (1001)) AND ((`name`) = ('byx'))) OR ((`gender`) = ('F'))", c6.getSql());
        Condition c7 = column("name").eq(column("nickname"));
        assertEquals("(`name`) = (`nickname`)", c7.getSql());
        Condition c8 = column("name").of("b").eq(column("nickname").of("u"));
        assertEquals("(`b`.`name`) = (`u`.`nickname`)", c8.getSql());
        Condition c9 = column("id").eq(literal(1001)).and(column("name").eq(column("nickname")));
        assertEquals("((`id`) = (1001)) AND ((`name`) = (`nickname`))", c9.getSql());
        Condition c10 = column("level").gt(literal(5));
        assertEquals("(`level`) > (5)", c10.getSql());
        Condition c11 = column("level").lt(column("score"));
        assertEquals("(`level`) < (`score`)", c11.getSql());
        Condition c12 = literal("byx").eq(column("nickname"));
        assertEquals("('byx') = (`nickname`)", c12.getSql());
    }
}
