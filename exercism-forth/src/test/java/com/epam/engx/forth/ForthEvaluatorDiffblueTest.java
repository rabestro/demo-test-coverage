package com.epam.engx.forth;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ForthEvaluatorDiffblueTest {
    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(Iterable)}
     */
    @Test
    void testEvaluateProgram() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();
        Iterable<String> commands = mock(Iterable.class);
        doNothing().when(commands).forEach(Mockito.<Consumer<String>>any());
        List<Integer> actualEvaluateProgramResult = forthEvaluator.evaluateProgram(commands);
        verify(commands).forEach(Mockito.<Consumer<String>>any());
        assertTrue(actualEvaluateProgramResult.isEmpty());
    }
}
