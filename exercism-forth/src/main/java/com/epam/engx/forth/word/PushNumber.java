package com.epam.engx.forth.word;

import java.util.Deque;
import java.util.Objects;

/**
 * A class that represents a Forth word which pushes a number on the stack.
 */
public final class PushNumber extends AbstractForthWord {

    private final int number;

    private PushNumber(int number) {
        this.number = number;
    }

    public static PushNumber of(String token) {
        var number = Integer.parseInt(token);
        return new PushNumber(number);
    }

    @Override
    public void accept(Deque<Integer> stack) {
        super.accept(stack);
        stack.push(number);
    }
}
