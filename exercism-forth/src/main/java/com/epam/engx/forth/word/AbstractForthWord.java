package com.epam.engx.forth.word;

import java.util.Deque;

public abstract sealed class AbstractForthWord implements ForthWord permits AbstractBinaryOperator, AbstractUnaryOperator {

    @Override
    public void accept(Deque<Integer> stack) {
        if (stack.size() < requiredStackSize()) {
            throw new IllegalStateException(requiredStackSizeMessage());
        }
    }

    private String requiredStackSizeMessage() {
        return name() + " requires that the stack contain at least "
               + this.requiredStackSize()
               + (this.requiredStackSize() == 1 ? " value" : " values");
    }
}
