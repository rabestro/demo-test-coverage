package com.epam.engx.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class PushNumberDiffblueTest {
    /**
     * Method under test: {@link PushNumber#of(String)}
     */
    @Test
    void testOf() {
        // Arrange
        String token = "42";

        // Act
        PushNumber actualOfResult = PushNumber.of(token);
        LinkedList<Integer> stack = new LinkedList<>();
        actualOfResult.accept(stack);

        // Assert
        assertEquals(1, stack.size());
        assertEquals(42, stack.get(0));
    }

    /**
     * Method under test: {@link PushNumber#accept(Deque)}
     */
    @Test
    void testAccept() {
        // Arrange
        PushNumber ofResult = PushNumber.of("42");
        LinkedList<Integer> stack = new LinkedList<>();

        // Act
        ofResult.accept(stack);

        // Assert
        assertEquals(1, stack.size());
        assertEquals(42, stack.get(0));
    }

    /**
     * Method under test: {@link PushNumber#accept(Deque)}
     */
    @Test
    void testAccept2() {
        // Arrange
        PushNumber ofResult = PushNumber.of("42");

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(2);

        // Act
        ofResult.accept(stack);

        // Assert
        assertEquals(2, stack.get(1));
        assertEquals(2, stack.size());
        assertEquals(42, stack.get(0));
    }
}
