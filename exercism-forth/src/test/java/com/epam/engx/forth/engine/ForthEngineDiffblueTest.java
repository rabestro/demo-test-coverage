package com.epam.engx.forth.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ForthEngineDiffblueTest {
    /**
     * Method under test: {@link ForthEngine#ForthEngine(Map)}
     */
    @Test
    void testConstructor() {
        HashMap<String, Consumer<Deque<Integer>>> words = new HashMap<>();
        ForthEngine actualForthEngine = new ForthEngine(words);
        assertTrue(actualForthEngine.get().isEmpty());
    }

    /**
     * Method under test: {@link ForthEngine#ForthEngine(Map)}
     */
    @Test
    void testConstructor2() {
        HashMap<String, Consumer<Deque<Integer>>> words = new HashMap<>();
        words.put("foo", mock(Consumer.class));
        ForthEngine actualForthEngine = new ForthEngine(words);
        assertTrue(actualForthEngine.get().isEmpty());
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    void testAccept() {
        ForthEngine forthEngine = new ForthEngine(new HashMap<>());
        String command = "Command";
        assertThrows(IllegalArgumentException.class, () -> forthEngine.accept(command));
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    void testAccept2() {
        Consumer<Deque<Integer>> consumer = mock(Consumer.class);
        doNothing().when(consumer).accept(Mockito.<Deque<Integer>>any());

        HashMap<String, Consumer<Deque<Integer>>> words = new HashMap<>();
        words.put("command", consumer);
        words.put(":", mock(Consumer.class));
        words.put(" ", mock(Consumer.class));
        ForthEngine forthEngine = new ForthEngine(words);
        String command = "Command";
        forthEngine.accept(command);
        verify(consumer).accept(Mockito.<Deque<Integer>>any());
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    void testAccept3() {
        Consumer<Deque<Integer>> consumer = mock(Consumer.class);
        doThrow(new IllegalArgumentException("foo")).when(consumer).accept(Mockito.<Deque<Integer>>any());
        Consumer<Deque<Integer>> consumer2 = mock(Consumer.class);
        doNothing().when(consumer2).accept(Mockito.<Deque<Integer>>any());

        HashMap<String, Consumer<Deque<Integer>>> words = new HashMap<>();
        words.put("command", consumer2);
        words.put("command", consumer);
        words.put(" ", mock(Consumer.class));
        ForthEngine forthEngine = new ForthEngine(words);
        String command = "Command";
        assertThrows(IllegalArgumentException.class, () -> forthEngine.accept(command));
        verify(consumer).accept(Mockito.<Deque<Integer>>any());
    }

    /**
     * Method under test: {@link ForthEngine#accept(String)}
     */
    @Test
    void testAccept4() {
        HashMap<String, Consumer<Deque<Integer>>> words = new HashMap<>();
        words.put("command", mock(Consumer.class));
        words.put("command", mock(Consumer.class));
        words.put(" ", mock(Consumer.class));
        ForthEngine forthEngine = new ForthEngine(words);
        String command = "42";
        forthEngine.accept(command);
        assertEquals(1, forthEngine.get().size());
    }

    /**
     * Method under test: {@link ForthEngine#get()}
     */
    @Test
    void testGet() {
        ForthEngine forthEngine = new ForthEngine(new HashMap<>());
        List<Integer> actualGetResult = forthEngine.get();
        assertTrue(actualGetResult.isEmpty());
    }

    /**
     * Method under test: {@link ForthEngine#get()}
     */
    @Test
    void testGet2() {
        HashMap<String, Consumer<Deque<Integer>>> words = new HashMap<>();
        words.put("foo", mock(Consumer.class));
        ForthEngine forthEngine = new ForthEngine(words);
        List<Integer> actualGetResult = forthEngine.get();
        assertTrue(actualGetResult.isEmpty());
    }
}
