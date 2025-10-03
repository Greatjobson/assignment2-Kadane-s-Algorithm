package algorithms;

/**
 * Implementation of Kadane's Algorithm to find the maximum subarray sum
 * with start and end indices tracking.
 * This algorithm scans the array linearly to compute the maximum sum
 * of a contiguous subarray in O(n) time complexity.
 */
public class KadanesAlgorithm {
    /**
     * Finds the maximum subarray sum and its boundaries.
     * @param arr the input array of integers
     * @return an array containing [maxSum, startIndex, endIndex]
     * @throws IllegalArgumentException if the input array is null or empty
     */
    public int[] findMaxSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        int maxSoFar = arr[0];  // Maximum sum found so far
        int maxEndingHere = arr[0];  // Maximum sum ending at current position
        int start = 0;  // Start index of the maximum subarray
        int end = 0;  // End index of the maximum subarray
        int tempStart = 0;  // Temporary start index for current subarray

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                maxEndingHere = arr[i];
                tempStart = i;
            } else {
                maxEndingHere = maxEndingHere + arr[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{maxSoFar, start, end};
    }
}