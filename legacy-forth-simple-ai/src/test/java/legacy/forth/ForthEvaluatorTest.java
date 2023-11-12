package legacy.forth;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForthEvaluatorTest {
    ForthEvaluator evaluator = new ForthEvaluator();

    @Test
    void testBasicOperation() {
        List<String> commands = Arrays.asList("5", "3", "+");
        assertEquals(Arrays.asList(8), evaluator.evaluateProgram(commands));
    }

    @Test
    void testComplexOperation() {
        List<String> commands = Arrays.asList("5", "3", "4", "+", "*");
        assertEquals(Arrays.asList(35), evaluator.evaluateProgram(commands));
    }

    @Test
    void testRedefinedNumbersException() {
        List<String> commands = Arrays.asList(": 2 1 1 + ;", "2");
        assertThrows(IllegalArgumentException.class, () -> evaluator.evaluateProgram(commands));
    }

    @Test
    void testUndefinedOperatorException() {
        List<String> commands = Arrays.asList("5", "3", "@");
        assertThrows(IllegalArgumentException.class, () -> evaluator.evaluateProgram(commands));
    }

    @Test
    void testDivisionByZeroException() {
        List<String> commands = Arrays.asList("5", "0", "/");
        assertThrows(IllegalArgumentException.class, () -> evaluator.evaluateProgram(commands));
    }

    @Test
    void testInsufficientValuesException() {
        List<String> commands = Arrays.asList("5", "+");
        assertThrows(IllegalArgumentException.class, () -> evaluator.evaluateProgram(commands));
    }

    @Test
    void testRedefinition() {
        List<String> commands = Arrays.asList(": sum 5 3 + ;", "sum");
        assertEquals(Arrays.asList(8), evaluator.evaluateProgram(commands));
    }
}
