package com.byx;

import com.byx.sql.FromItem;
import com.byx.sql.SelectItem;
import org.junit.jupiter.api.Test;

import static com.byx.sql.builder.Sql.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest
{
    @Test
    public void testSelectItem()
    {
        SelectItem item1 = column("name");
        assertEquals("`name`", item1.getSql());
        SelectItem item2 = column("name").as("n");
        assertEquals("`name` AS n", item2.getSql());
        SelectItem item3 = all();
        assertEquals("*", item3.getSql());
    }

    @Test
    public void testFromTest()
    {
        FromItem item1 = table("users");
        assertEquals("`users`", item1.getSql());
        FromItem item2 = table("users").as("u");
        assertEquals("`users` AS u", item2.getSql());
    }
}
