package stjean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class OperationMathematiqueTest {

    @org.junit.jupiter.api.Test
    @ParameterizedTest
    @ValueSource( ints = {2,-4,6,-8,12})
    void testestPositif( int number) {
        assertTrue(OperationMathematique.estPositif(number) , number + "error");
    }

    @org.junit.jupiter.api.Test
    void factorial() {
        int number = 3;
        int result = OperationMathematique.factorial(number);
        assertEquals(6, result);
    }
    @Test
    public void testSortDescendingOrder() {
        int[] input = {1, 3, 2, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, OperationMathematique.sort(input));
    }
}