package com.epam.engx.forth.word;


import java.util.Deque;
import java.util.function.Consumer;

@FunctionalInterface
public interface ForthWord extends Consumer<Deque<Integer>> {

    static ForthWord number(String token) {
        return stack -> stack.push(Integer.parseInt(token));
    }

    default int requiredStackSize() {
        return 0;
    }

    default String name() {
        return this.getClass().getSimpleName();
    }
}
