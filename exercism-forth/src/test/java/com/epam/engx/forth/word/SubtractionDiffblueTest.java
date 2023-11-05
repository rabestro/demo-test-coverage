package com.epam.engx.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class SubtractionDiffblueTest {
    /**
     * Method under test: {@link Subtraction#accept(Deque)}
     */
    @Test
    void testAccept() {
        Subtraction subtraction = new Subtraction();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.add(2);
        subtraction.accept(stack);
        assertEquals(1, stack.get(0));
        assertEquals(1, stack.size());
    }

    /**
     * Method under test: {@link Subtraction#accept(Deque)}
     */
    @Test
    void testAccept2() {
        Subtraction subtraction = new Subtraction();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(0);
        stack.add(1);
        stack.add(2);
        subtraction.accept(stack);
        assertEquals(1, stack.get(0));
        assertEquals(2, stack.get(1));
        assertEquals(2, stack.size());
    }
}
