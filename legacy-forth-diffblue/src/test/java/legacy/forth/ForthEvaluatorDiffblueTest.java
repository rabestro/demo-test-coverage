package legacy.forth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ForthEvaluatorDiffblueTest {
    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();
        ArrayList<String> commands = new ArrayList<>();
        List<Integer> actualEvaluateProgramResult = forthEvaluator.evaluateProgram(commands);
        assertTrue(actualEvaluateProgramResult.isEmpty());
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram2() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> commands = new ArrayList<>();
        commands.add("foo");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(commands));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram3() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> commands = new ArrayList<>();
        commands.add(" +");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(commands));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram4() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> commands = new ArrayList<>();
        commands.add(" ");
        List<Integer> actualEvaluateProgramResult = forthEvaluator.evaluateProgram(commands);
        assertTrue(actualEvaluateProgramResult.isEmpty());
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram5() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> commands = new ArrayList<>();
        commands.add("-");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(commands));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram6() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> commands = new ArrayList<>();
        commands.add("*");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(commands));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram7() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> commands = new ArrayList<>();
        commands.add("42");
        List<Integer> actualEvaluateProgramResult = forthEvaluator.evaluateProgram(commands);
        assertEquals(1, actualEvaluateProgramResult.size());
        assertEquals(42, actualEvaluateProgramResult.get(0));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram8() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> commands = new ArrayList<>();
        commands.add("/");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(commands));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram9() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> commands = new ArrayList<>();
        commands.add("dup");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(commands));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram10() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> commands = new ArrayList<>();
        commands.add("drop");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(commands));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram11() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> commands = new ArrayList<>();
        commands.add("swap");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(commands));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram12() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> commands = new ArrayList<>();
        commands.add("over");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(commands));
    }

    /**
     * Method under test: {@link ForthEvaluator#evaluateProgram(List)}
     */
    @Test
    void testEvaluateProgram13() {
        ForthEvaluator forthEvaluator = new ForthEvaluator();

        ArrayList<String> commands = new ArrayList<>();
        commands.add("No definition available for operator \"%s\"");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(commands));
    }
}
