package com.epam.engx.forth.engine;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ForthEngineFactoryDiffblueTest {
    /**
     * Method under test: {@link ForthEngineFactory#get()}
     */
    @Test
    void testGet() {
        ForthEngineFactory forthEngineFactory = new ForthEngineFactory();
        ForthEngine actualGetResult = forthEngineFactory.get();
        assertTrue(actualGetResult.get().isEmpty());
    }
}
