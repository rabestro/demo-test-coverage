package com.epam.engx.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class DuplicatingDiffblueTest {
    /**
     * Method under test: {@link Duplicating#accept(Deque)}
     */
    @Test
    void testAccept() {
        Duplicating duplicating = new Duplicating();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(2);
        duplicating.accept(stack);
        assertEquals(2, stack.get(0));
        assertEquals(2, stack.get(1));
        assertEquals(2, stack.size());
    }
}
