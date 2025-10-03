package algorithms;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive unit tests covering edge cases
 * (empty arrays, single elements, duplicates)
 */
public class KadanesAlgorithmTest {
    /**
     * an object of the kadane class that we will use in tests in the form
     * testObject
     */
    KadanesAlgorithm testObject = new KadanesAlgorithm();

    /**tests for empty and null array
     */

    @Test
    void testEmptyOrNullArray(){
        int[] emptyArr = new int[]{};
        int[] nullArray = null;
        assertThrows(IllegalArgumentException.class, () -> testObject.findMaxSubarray(emptyArr));
        assertThrows(IllegalArgumentException.class, () -> testObject.findMaxSubarray(nullArray));
    }

    /**
     * single elements test
     */
    @Test
    void testSingleElements(){
        int[] array = new int[]{5};
        assertArrayEquals(new int[]{5, 0, 0},testObject.findMaxSubarray(array)); //subarray [5]
    }

    /**
     * test an array with the same numbers.
     */
    @Test
    void testDuplicates() {
        int[] result = testObject.findMaxSubarray(new int[]{5, 5, 5, 5, 5, 5, 5});
        assertArrayEquals(new int[]{35, 0, 6}, result); // Subarray [5, 5, 5, 5, 5, 5, 5]
    }
    /**
     * test with negative elements
     */
    @Test
    void testAllNegative(){
        int[] result = testObject.findMaxSubarray(new int[]{-2, -5, -10, -9, -1, -2,-7, -11});
        assertArrayEquals(new int[]{-1, 4, 4}, result); // subarray [-1]
    }

    /**
     * testing a random element array
     */
    @Test
    void testRandomElementArray(){
        int[] result = testObject.findMaxSubarray(new int[]{-8, 7, 11, 4, 0, -17, 41, -50, 30, 21, 5});
        assertArrayEquals(new int[]{56, 8, 10}, result); //subarray [30, 21, 5]
    }
}

