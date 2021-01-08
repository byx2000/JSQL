package com.byx;

import com.byx.sql.*;
import org.junit.jupiter.api.Test;

import static com.byx.sql.builder.Sql.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass
{
    @Test
    public void testSelectItem()
    {
        SelectItem item1 = column("users");
        assertEquals("`users`", item1.getSql());
        SelectItem item2 = column("users").as("u");
        assertEquals("`users` AS u", item2.getSql());
        SelectItem item3 = all();
        assertEquals("*", item3.getSql());
    }
}
