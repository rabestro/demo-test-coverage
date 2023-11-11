package com.epam.engx.forth.word;


import java.util.Collection;
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

    default void ensureSize(Collection<Integer> stack) {
        if (stack.size() < requiredStackSize()) {
            throw new IllegalStateException(errorMessage());
        }
    }

    default String name() {
        return this.getClass().getSimpleName();
    }

    private String errorMessage() {
        return name() + " requires that the stack contain at least "
               + this.requiredStackSize()
               + (this.requiredStackSize() == 1 ? " value" : " values");
    }
}
