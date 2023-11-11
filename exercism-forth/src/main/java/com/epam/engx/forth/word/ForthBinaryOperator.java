package com.epam.engx.forth.word;

@FunctionalInterface
public interface ForthBinaryOperator extends ForthWord {

    @Override
    default int requiredStackSize() {
        return 2;
    }
}
