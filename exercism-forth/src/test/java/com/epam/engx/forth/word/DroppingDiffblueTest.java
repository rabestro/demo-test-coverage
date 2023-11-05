package com.epam.engx.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class DroppingDiffblueTest {
    /**
     * Method under test: {@link Dropping#accept(Deque)}
     */
    @Test
    void testAccept() {
        Dropping dropping = new Dropping();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(2);
        dropping.accept(stack);
        assertTrue(stack.isEmpty());
    }

    /**
     * Method under test: {@link Dropping#accept(Deque)}
     */
    @Test
    void testAccept2() {
        Dropping dropping = new Dropping();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.add(2);
        dropping.accept(stack);
        assertEquals(1, stack.size());
        assertEquals(2, stack.get(0));
    }

    /**
     * Method under test: {@link Dropping#accept(Deque)}
     */
    @Test
    void testAccept3() {
        Dropping dropping = new Dropping();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(0);
        stack.add(1);
        stack.add(2);
        dropping.accept(stack);
        assertEquals(1, stack.get(0));
        assertEquals(2, stack.get(1));
        assertEquals(2, stack.size());
    }
}
