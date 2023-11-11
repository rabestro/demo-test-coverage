package com.epam.engx.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ForthBinaryOperatorDiffblueTest {
    /**
     * Method under test: {@link ForthBinaryOperator#requiredStackSize()}
     */
    @Test
    void testRequiredStackSize() {
        Addition addition = new Addition();
        int actualRequiredStackSizeResult = addition.requiredStackSize();
        assertEquals(2, actualRequiredStackSizeResult);
    }
}
