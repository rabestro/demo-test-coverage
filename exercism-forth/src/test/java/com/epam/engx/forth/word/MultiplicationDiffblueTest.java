package com.epam.engx.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class MultiplicationDiffblueTest {
    /**
     * Method under test: {@link Multiplication#accept(Deque)}
     */
    @Test
    void testAccept() {
        Multiplication multiplication = new Multiplication();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.add(2);
        multiplication.accept(stack);
        assertEquals(1, stack.size());
        assertEquals(2, stack.get(0));
    }

    /**
     * Method under test: {@link Multiplication#accept(Deque)}
     */
    @Test
    void testAccept2() {
        Multiplication multiplication = new Multiplication();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(0);
        stack.add(1);
        stack.add(2);
        multiplication.accept(stack);
        assertEquals(0, stack.get(0));
        assertEquals(2, stack.get(1));
        assertEquals(2, stack.size());
    }
}
