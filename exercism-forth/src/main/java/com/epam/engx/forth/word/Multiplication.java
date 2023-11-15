package com.epam.engx.forth.word;

import java.util.Deque;

public final class Multiplication extends AbstractBinaryOperator {

    @Override
    public void accept(Deque<Integer> stack) {
        super.accept(stack);
        stack.push(stack.pop() * stack.pop());
    }
}
