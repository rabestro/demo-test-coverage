package com.epam.engx.forth.word;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ForthWordDiffblueTest {
    /**
     * Method under test: {@link ForthWord#builtInWords()}
     */
    @Test
    void testBuiltInWords() {
        Map<String, ForthWord> actualBuiltInWordsResult = ForthWord.builtInWords();
        assertEquals(8, actualBuiltInWordsResult.size());
    }

    /**
     * Method under test: {@link ForthWord#number(String)}
     */
    @Test
    void testNumber() {
        String token = "42";
        ForthWord actualNumberResult = ForthWord.number(token);
        LinkedList<Integer> integerList = new LinkedList<>();
        actualNumberResult.accept(integerList);
        assertEquals(1, integerList.size());
        assertEquals(42, integerList.get(0));
    }

    /**
     * Method under test: {@link ForthWord#requiredStackSize()}
     */
    @Test
    void testRequiredStackSize() {
        Addition addition = new Addition();
        int actualRequiredStackSizeResult = addition.requiredStackSize();
        assertEquals(2, actualRequiredStackSizeResult);
    }

    /**
     * Method under test: {@link ForthWord#ensureSize(Collection)}
     */
    @Test
    void testEnsureSize() {
        Addition addition = new Addition();
        ArrayList<Integer> stack = new ArrayList<>();
        assertThrows(IllegalStateException.class, () -> addition.ensureSize(stack));
    }

    /**
     * Method under test: {@link ForthWord#ensureSize(Collection)}
     */
    @Test
    void testEnsureSize2() {
        Addition addition = new Addition();

        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(2);
        assertThrows(IllegalStateException.class, () -> addition.ensureSize(stack));
    }

    /**
     * Method under test: {@link ForthWord#ensureSize(Collection)}
     */
    @Test
    void testEnsureSize3() {
        Addition addition = new Addition();

        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(1);
        stack.add(2);
        addition.ensureSize(stack);
        assertEquals(2, addition.requiredStackSize());
    }
}
