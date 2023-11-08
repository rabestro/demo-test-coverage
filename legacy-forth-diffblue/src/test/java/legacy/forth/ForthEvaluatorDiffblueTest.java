package legacy.forth;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForthEvaluatorDiffblueTest {
    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("foo");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram2() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("9");
        expression.add("foo");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram3() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("9");
        List<Integer> actualEvaluateProgramResult = forthEvaluator.evaluateProgram(expression);
        assertEquals(1, actualEvaluateProgramResult.size());
        assertEquals(9, actualEvaluateProgramResult.get(0));
        assertTrue(forthEvaluator.usrOpDefinition.isEmpty());
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram4() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("*");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram5() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("DUP");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram6() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("DROP");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram7() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("OVER");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram8() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("SWAP");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram9() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("42");
        List<Integer> actualEvaluateProgramResult = forthEvaluator.evaluateProgram(expression);
        assertEquals(1, actualEvaluateProgramResult.size());
        assertEquals(42, actualEvaluateProgramResult.get(0));
        assertTrue(forthEvaluator.usrOpDefinition.isEmpty());
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram10() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("U");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram11() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("");
        assertThrows(IllegalStateException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram12() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add(" ");
        List<Integer> actualEvaluateProgramResult = forthEvaluator.evaluateProgram(expression);
        assertTrue(actualEvaluateProgramResult.isEmpty());
        assertTrue(forthEvaluator.usrOpDefinition.isEmpty());
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram13() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add(";");
        assertThrows(IllegalStateException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram14() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("Multiplication requires that the stack contain at least 2 values");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram15() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("Duplicating requires that the stack contain at least 1 value");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram16() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("Dropping requires that the stack contain at least 1 value");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram17() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("Overing requires that the stack contain at least 2 values");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram18() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("Swapping requires that the stack contain at least 2 values");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram19() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> expression = new ArrayList<>();
        expression.add("No definition available for operator \"%s\"");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }
}
