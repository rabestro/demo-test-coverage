package com.epam.engx.forth.word;


import java.util.Deque;
import java.util.function.Consumer;

@FunctionalInterface
public interface ForthWord extends Consumer<Deque<Integer>> {

    default int requiredStackSize() {
        return 0;
    }

    default String name() {
        return this.getClass().getSimpleName();
    }
}
