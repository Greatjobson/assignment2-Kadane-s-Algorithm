package algorithms;

import metrics.PerformanceTracker;

/**
 * Implementation of Kadane's Algorithm to find the maximum subarray sum
 * with start and end indices tracking.
 * This algorithm scans the array linearly to compute the maximum sum
 * of a contiguous subarray in O(n) time complexity.
 */
public class KadanesAlgorithm {
    private PerformanceTracker tracker = new PerformanceTracker();

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
        tracker.start(); //launching the tracker after checking the array

        int maxSoFar = arr[0];  // Maximum sum found so far
        int maxEndingHere = arr[0];  // Maximum sum ending at current position
        int start = 0;  // Start index of the maximum subarray
        int end = 0;  // End index of the maximum subarray
        int tempStart = 0;  // Temporary start index for current subarray
        tracker.recordAccess(); // Счётчик первого доступа к массиву

        for (int i = 1; i < arr.length; i++) {
            tracker.recordAccess(); // Доступ к arr[i]
            if (arr[i] > maxEndingHere + arr[i]) {
                tracker.recordComparison(); // Сравнение
                maxEndingHere = arr[i];
                tempStart = i;
            } else {
                tracker.recordComparison(); // Сравнение
                maxEndingHere = maxEndingHere + arr[i];
            }

            tracker.recordAccess(); // Доступ для проверки maxSoFar
            if (maxEndingHere > maxSoFar) {
                tracker.recordComparison(); // Сравнение
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        tracker.stop();
        tracker.recordMemoryAllocation(); // Счётчик выделения памяти для возвращаемого массива
        return new int[]{maxSoFar, start, end};
    }

    /**
     * Returns the performance metrics for the last execution.
     * @return the PerformanceTracker instance
     */
    public PerformanceTracker getPerformanceTracker() {
        return tracker;
    }
}