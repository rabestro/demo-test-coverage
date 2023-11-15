package com.epam.engx.forth.word;

import java.util.Deque;

/**
 * Represents the subtraction operator in a stack-based evaluator for a subset of Forth.
 * <p>
 * This class extends the AbstractBinaryOperator class and provides the implementation for the subtraction operator.
 * The subtraction operation is performed by popping two integers from the stack, subtracting the second integer from the first,
 * and pushing the result back onto the stack.
 * <p>
 * Example usage:
 * Deque<Integer> stack = new ArrayDeque<>();
 * stack.push(5);
 * stack.push(3);
 * <p>
 * Subtraction subtraction = new Subtraction();
 * subtraction.accept(stack);
 * <p>
 * int result = stack.pop(); // result = 2
 *
 * @see AbstractBinaryOperator
 */
public final class Subtraction extends AbstractBinaryOperator {

    @Override
    public void accept(Deque<Integer> stack) {
        super.accept(stack);
        stack.push(-stack.pop() + stack.pop());
    }
}
