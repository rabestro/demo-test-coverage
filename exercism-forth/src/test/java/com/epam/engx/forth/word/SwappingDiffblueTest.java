package com.epam.engx.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class SwappingDiffblueTest {
    /**
     * Method under test: {@link Swapping#accept(Deque)}
     */
    @Test
    void testAccept() {
        Swapping swapping = new Swapping();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.add(2);
        swapping.accept(stack);
        assertEquals(1, stack.get(1));
        assertEquals(2, stack.get(0));
        assertEquals(2, stack.size());
    }
}
