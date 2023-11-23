package com.epam.engx.forth.word;

import java.util.Deque;
import java.util.Optional;
import java.util.stream.Stream;

public final class Division extends AbstractBinaryOperator {

    @Override
    public void accept(Deque<Integer> stack) {
        super.accept(stack);

        int divisor = stack.pop();
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by 0 is not allowed");
        }
        int dividend = stack.pop();
        stack.push(dividend / divisor);
    }
}
