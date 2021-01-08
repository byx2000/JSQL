package com.byx;

import com.byx.sql.SelectItem;
import org.junit.jupiter.api.Test;

import static com.byx.sql.builder.Sql.column;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass
{
    @Test
    public void test()
    {
        SelectItem item1 = column("users");
        assertEquals("`users`", item1.getSql());
        SelectItem item2 = column("users").as("u");
        assertEquals("`users` AS u", item2.getSql());
    }
}
