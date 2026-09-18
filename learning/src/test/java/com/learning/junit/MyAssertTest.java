package com.learning.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    public void test() {
        boolean test = todos.contains("AWS");
        boolean test1 = todos.contains("DSA");

        assertFalse(test1, "True condition");
        assertTrue(test, "False condition");
        assertArrayEquals(new int[] {10,20,30}, new int[] {10,20,40}, "Arrays are diiferent");

        assertEquals(3, todos.size(), "Size not as expected");
    }
}
