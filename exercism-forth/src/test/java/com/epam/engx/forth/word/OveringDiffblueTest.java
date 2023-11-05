package com.epam.engx.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class OveringDiffblueTest {
    /**
     * Method under test: {@link Overing#accept(Deque)}
     */
    @Test
    void testAccept() {
        Overing overing = new Overing();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.add(2);
        overing.accept(stack);
        assertEquals(1, stack.get(1));
        assertEquals(2, stack.get(0));
        assertEquals(2, stack.get(2));
        assertEquals(3, stack.size());
    }
}
