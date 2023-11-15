package com.epam.engx.forth.word;

import java.util.Deque;

public final class Swapping extends AbstractBinaryOperator {

    @Override
    public void accept(Deque<Integer> stack) {
        super.accept(stack);

        int a = stack.pop();
        int b = stack.pop();
        stack.push(a);
        stack.push(b);
    }
}
