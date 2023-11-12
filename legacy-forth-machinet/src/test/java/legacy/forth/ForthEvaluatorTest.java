package legacy.forth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForthEvaluatorTest {
    private ForthEvaluator forthEvaluator;

    @BeforeEach
    public void setUp() {
        forthEvaluator = new ForthEvaluator();
    }

    @Test
    public void testEvaluateProgramWhenExpressionIsEmptyThenReturnEmptyList() {
        List<String> expression = new ArrayList<>();
        List<Integer> result = forthEvaluator.evaluateProgram(expression);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testEvaluateProgramWhenExpressionContainsOnlyNumbersThenReturnListWithNumbers() {
        List<String> expression = Arrays.asList("1", "2", "3");
        List<Integer> result = forthEvaluator.evaluateProgram(expression);
        Assertions.assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    public void testEvaluateProgramWhenExpressionContainsValidOperatorsThenReturnCorrectResult() {
        List<String> expression = Arrays.asList("1", "2", "+");
        List<Integer> result = forthEvaluator.evaluateProgram(expression);
        Assertions.assertEquals(Arrays.asList(3), result);
    }

    @Test
    public void testEvaluateProgramWhenExpressionContainsUndefinedOperatorThenThrowException() {
        List<String> expression = Arrays.asList("1", "2", "unknownOp");
        Assertions.assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }

    @Test
    public void testEvaluateProgramWhenExpressionContainsDivisionByZeroThenThrowException() {
        List<String> expression = Arrays.asList("1", "0", "/");
        Assertions.assertThrows(IllegalArgumentException.class, () -> forthEvaluator.evaluateProgram(expression));
    }
}
