package com.epam.engx.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class AdditionDiffblueTest {
    /**
     * Method under test: {@link Addition#accept(Deque)}
     */
    @Test
    void testAccept() {
        Addition addition = new Addition();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.add(2);
        addition.accept(stack);
        assertEquals(1, stack.size());
        assertEquals(3, stack.get(0));
    }

    /**
     * Method under test: {@link Addition#accept(Deque)}
     */
    @Test
    void testAccept2() {
        Addition addition = new Addition();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(0);
        stack.add(1);
        stack.add(2);
        addition.accept(stack);
        assertEquals(1, stack.get(0));
        assertEquals(2, stack.get(1));
        assertEquals(2, stack.size());
    }
}
