package com.epam.engx.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class DivisionDiffblueTest {
    /**
     * Method under test: {@link Division#accept(Deque)}
     */
    @Test
    void testAccept() {
        Division division = new Division();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(1);
        stack.add(2);
        division.accept(stack);
        assertEquals(1, stack.size());
        assertEquals(2, stack.get(0));
    }

    /**
     * Method under test: {@link Division#accept(Deque)}
     */
    @Test
    void testAccept2() {
        Division division = new Division();

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(0);
        stack.add(1);
        stack.add(2);
        assertThrows(IllegalArgumentException.class, () -> division.accept(stack));
    }
}
