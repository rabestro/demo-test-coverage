package com.epam.engx.forth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class ForthEngineDiffblueTest {
    /**
     * Method under test: default or parameterless constructor of {@link ForthEngine}
     */
    @Test
    void testConstructor() {
        ForthEngine actualForthEngine = new ForthEngine();
        assertTrue(actualForthEngine.get().isEmpty());
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    void testAccept() {
        ForthEngine forthEngine = new ForthEngine();
        String command = "Command";
        assertThrows(IllegalArgumentException.class, () -> forthEngine.accept(command));
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    void testAccept2() {
        ForthEngine forthEngine = new ForthEngine();
        String command = "42";
        forthEngine.accept(command);
        assertEquals(1, forthEngine.get().size());
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    void testAccept3() {
        ForthEngine forthEngine = new ForthEngine();
        String command = ": 42";
        assertThrows(IllegalArgumentException.class, () -> forthEngine.accept(command));
    }

    /**
     * Method under test: {@link ForthEngine#get()}
     */
    @Test
    void testGet() {
        ForthEngine forthEngine = new ForthEngine();
        List<Integer> actualGetResult = forthEngine.get();
        assertTrue(actualGetResult.isEmpty());
    }
}
