package com.epam.engx.forth.word;

import java.util.Deque;

public final class Multiplication implements ForthBinaryOperator {
    @Override
    public void accept(Deque<Integer> stack) {
        ensureSize(stack);
        stack.push(stack.pop() * stack.pop());
    }
}
