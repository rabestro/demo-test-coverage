package legacy.forth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ForthEvaluatorTest {
    private ForthEvaluator forthEvaluator;

    @BeforeEach
    public void setUp() {
        forthEvaluator = new ForthEvaluator();
    }

    @Test
    @Disabled
    public void testEvaluateProgramWhenExpressionContainsOnlyNumbersThenReturnSameNumbers() {
        List<String> expression = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, forthEvaluator.evaluateProgram(expression));
    }

    @Test
    public void testEvaluateProgramWhenExpressionContainsOnlyOperatorsThenThrowException() {
        List<String> expression = Arrays.asList("+", "-", "*", "/");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    @Test
    @Disabled
    public void testEvaluateProgramWhenExpressionContainsUndefinedUserOperatorThenThrowException() {
        List<String> expression = Arrays.asList(": NOOP ;", "NOOP");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    @Test
    public void testEvaluateProgramWhenExpressionContainsDefinedUserOperatorThenReturnCorrectResult() {
        List<String> expression = Arrays.asList(": INCREMENT 1 + ;", "5 INCREMENT");
        List<Integer> expected = Arrays.asList(6);
        assertEquals(expected, forthEvaluator.evaluateProgram(expression));
    }

    @Test
    @Disabled
    public void testEvaluateProgramWhenExpressionContainsRedefinitionOfBuiltInOperatorThenThrowException() {
        List<String> expression = Arrays.asList(": + * ;", "2 3 +");
        assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }
}
