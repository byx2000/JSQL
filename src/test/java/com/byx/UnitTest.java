package com.byx;

import com.byx.sql.*;
import org.junit.jupiter.api.Test;

import static com.byx.sql.builder.Sql.*;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest
{
    @Test
    public void testSelectItem()
    {
        SelectItem s1 = column("name");
        assertEquals("`name`", s1.getSql());
        SelectItem s2 = column("name").as("n");
        assertEquals("`name` AS 'n'", s2.getSql());
        SelectItem s3 = column("name").of("b");
        assertEquals("`b`.`name`", s3.getSql());
        SelectItem s4 = column("name").of("b").as("n");
        assertEquals("`b`.`name` AS 'n'", s4.getSql());
        SelectItem s5 = all();
        assertEquals("*", s5.getSql());
        SelectItem s6 = column("level").add(literal(5));
        assertEquals("(`level`) + (5)", s6.getSql());
        SelectItem s7 = column("level").sub(literal(5)).as("n");
        assertEquals("(`level`) - (5) AS 'n'", s7.getSql());
        SelectItem s8 = column("score").of("b").add(literal(3.14));
        assertEquals("(`b`.`score`) + (3.14)", s8.getSql());
        SelectItem s9 = column("score").of("b").add(literal(3.14)).as("s");
        assertEquals("(`b`.`score`) + (3.14) AS 's'", s9.getSql());
        SelectItem s10 = column("likeCount").add(column("dislikeCount")).as("heat");
        assertEquals("(`likeCount`) + (`dislikeCount`) AS 'heat'", s10.getSql());
    }

    @Test
    public void testFromItem()
    {
        FromItem f1 = table("users");
        assertEquals("`users`", f1.getSql());
        FromItem f2 = table("users").as("u");
        assertEquals("`users` AS 'u'", f2.getSql());
    }

    @Test
    public void testArithExpr()
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
        ArithExpr e7 = column("level").add(literal(3));
        assertEquals("(`level`) + (3)", e7.getSql());
        ArithExpr e8 = literal("byx").sub(column("score"));
        assertEquals("('byx') - (`score`)", e8.getSql());
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
        Condition c13 = column("score").add(literal(10)).gt(literal(5.5));
        assertEquals("((`score`) + (10)) > (5.5)", c13.getSql());
    }

    @Test
    public void testQuery()
    {
        Query q1 = select(column("id")).from(table("users"));
        assertEquals("SELECT `id` FROM `users`", q1.getSql());
        Query q2 = select(column("id").as("i")).from(table("users").as("u"));
        assertEquals("SELECT `id` AS 'i' FROM `users` AS 'u'", q2.getSql());
        Query q3 = select(column("name").of("b")).from(table("books").as("b"));
        assertEquals("SELECT `b`.`name` FROM `books` AS 'b'", q3.getSql());
        Query q4 = select(column("name").of("b").as("n")).from(table("books").as("b"));
        assertEquals("SELECT `b`.`name` AS 'n' FROM `books` AS 'b'", q4.getSql());
        Query q5 = select(column("id")).from(table("users")).where(column("username").eq(literal("byx")));
        assertEquals("SELECT `id` FROM `users` WHERE (`username`) = ('byx')", q5.getSql());
        Query q6 = select(column("id").as("i")).from(table("users").as("u")).where(column("username").of("u").eq(literal("aaa")));
        assertEquals("SELECT `id` AS 'i' FROM `users` AS 'u' WHERE (`u`.`username`) = ('aaa')", q6.getSql());
        Query q7 = select(column("name"), column("password")).from(table("books"), table("users"));
        assertEquals("SELECT `name`, `password` FROM `books`, `users`", q7.getSql());
        Query q8 = select(column("name").of("b"), column("password").of("u")).from(table("books").as("b"), table("users").as("u"));
        assertEquals("SELECT `b`.`name`, `u`.`password` FROM `books` AS 'b', `users` AS 'u'", q8.getSql());
        Query q9 = select(column("id")).from(table("users")).where(literal("byx").eq(column("username")));
        assertEquals("SELECT `id` FROM `users` WHERE ('byx') = (`username`)", q9.getSql());
        Query q10 = select(column("id")).from(table("users")).where(column("level").add(literal(2)).gt(column("score").sub(literal(3))));
        assertEquals("SELECT `id` FROM `users` WHERE ((`level`) + (2)) > ((`score`) - (3))", q10.getSql());
        Query q11 = select(column("id")).from(table("users")).where(column("username").eq(literal("byx")).and(column("password").eq(literal("123"))));
        assertEquals("SELECT `id` FROM `users` WHERE ((`username`) = ('byx')) AND ((`password`) = ('123'))", q11.getSql());
    }
}
