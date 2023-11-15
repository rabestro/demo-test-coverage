package com.epam.engx.forth.word;

import java.util.Deque;

public final class Dropping extends AbstractUnaryOperator {

    @Override
    public void accept(Deque<Integer> stack) {
        super.accept(stack);
        stack.pop();
    }
}
