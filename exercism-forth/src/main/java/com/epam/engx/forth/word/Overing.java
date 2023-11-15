package com.epam.engx.forth.word;

import java.util.Deque;

import static java.util.Objects.requireNonNull;

public final class Overing extends AbstractBinaryOperator {

    @Override
    public void accept(Deque<Integer> stack) {
        super.accept(stack);

        int a = stack.pop();
        int b = requireNonNull(stack.peek());
        stack.push(a);
        stack.push(b);
    }
}
