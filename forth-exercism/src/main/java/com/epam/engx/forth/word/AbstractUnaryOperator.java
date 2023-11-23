package com.epam.engx.forth.word;

public abstract non-sealed class AbstractUnaryOperator extends AbstractForthWord {

    @Override
    public int requiredStackSize() {
        return 1;
    }
}
