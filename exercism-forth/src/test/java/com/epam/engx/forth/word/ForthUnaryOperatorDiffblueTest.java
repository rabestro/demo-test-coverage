package com.epam.engx.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ForthUnaryOperatorDiffblueTest {
    /**
     * Method under test: {@link ForthUnaryOperator#requiredStackSize()}
     */
    @Test
    void testRequiredStackSize() {
        Dropping dropping = new Dropping();
        int actualRequiredStackSizeResult = dropping.requiredStackSize();
        assertEquals(1, actualRequiredStackSizeResult);
    }
}
