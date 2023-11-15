package com.epam.engx.forth.word;

import java.util.Deque;

public final class Duplicating extends AbstractUnaryOperator {

    @Override
    public void accept(Deque<Integer> stack) {
        super.accept(stack);
        stack.push(stack.peek());
    }
}
