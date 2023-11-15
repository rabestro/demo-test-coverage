package com.epam.engx.forth.word;

import java.util.Deque;

import static java.util.Objects.requireNonNull;

public abstract sealed class AbstractForthWord implements ForthWord
    permits AbstractBinaryOperator, AbstractUnaryOperator, PushNumber {

    @Override
    public void accept(Deque<Integer> stack) {
        requireNonNull(stack, "Stack cannot be null");
        validateStackSize(stack);
    }

    private void validateStackSize(Deque<Integer> stack) {
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
