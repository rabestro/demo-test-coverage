package com.epam.engx.forth.word;

import java.util.Deque;

public final class Addition implements ForthBinaryOperator {

    @Override
    public void accept(Deque<Integer> stack) {
        ensureSize(stack);
        stack.push(stack.pop() + stack.pop());
    }
}
