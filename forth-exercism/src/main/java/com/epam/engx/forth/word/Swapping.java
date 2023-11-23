package com.epam.engx.forth.word;

import java.util.Deque;

/**
 * This class represents the SWAP operation in Forth evaluator.
 * It is a binary operator that swaps the top two elements on the stack.
 *
 * <p>The SWAP operation takes the top two elements on the stack and swaps their positions.
 * For example, if the stack contains [5, 10], after performing SWAP, the stack will be [10, 5].
 *
 * <p>This class extends the AbstractBinaryOperator class and implements the accept method.
 * The accept method takes a Deque<Integer> stack as input, pops the top two elements from the stack,
 * and pushes them back in reverse order.
 */
public final class Swapping extends AbstractBinaryOperator {

    @Override
    public void accept(Deque<Integer> stack) {
        super.accept(stack);

        int a = stack.pop();
        int b = stack.pop();
        stack.push(a);
        stack.push(b);
    }
}
