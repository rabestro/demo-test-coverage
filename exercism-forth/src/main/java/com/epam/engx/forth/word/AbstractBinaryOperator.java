package com.epam.engx.forth.word;

public abstract non-sealed class AbstractBinaryOperator extends AbstractForthWord {

    @Override
    public int requiredStackSize() {
        return 2;
    }
}
