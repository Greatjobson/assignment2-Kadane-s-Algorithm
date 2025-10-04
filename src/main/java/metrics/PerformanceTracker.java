package metrics;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A utility class to track performance metrics during algorithm execution.
 * Collects data on comparisons, swaps, array accesses, and memory allocations.
 * Also supports exporting metrics to CSV for empirical analysis.
 */
public class PerformanceTracker {
    private long comparisons;  // Number of comparisons
    private long swaps;       // Number of swaps
    private long arrayAccesses;  // Number of array accesses
    private long memoryAllocations;  // Number of memory allocations
    private long startTime;    // Start time in nanoseconds
    private long endTime;      // End time in nanoseconds

    /**
     * Initializes a new PerformanceTracker with zeroed metrics.
     */
    public PerformanceTracker() {
        reset();
    }

    /**
     * Resets all metrics to zero.
     */
    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        memoryAllocations = 0;
        startTime = 0;
        endTime = 0;
    }

    /**
     * Starts the performance tracking by recording the current time.
     */
    public void start() {
        reset();
        startTime = System.nanoTime();
    }

    /**
     * Stops the performance tracking by recording the current time.
     */
    public void stop() {
        endTime = System.nanoTime();
    }

    /**
     * Increments the comparison counter.
     */
    public void recordComparison() {
        comparisons++;
    }

    /**
     * Increments the swap counter.
     */
    public void recordSwap() {
        swaps++;
    }

    /**
     * Increments the array access counter.
     */
    public void recordAccess() {
        arrayAccesses++;
    }

    /**
     * Increments the memory allocation counter.
     */
    public void recordMemoryAllocation() {
        memoryAllocations++;
    }

    /**
     * Returns the total number of comparisons.
     * @return the number of comparisons
     */
    public long getComparisons() {
        return comparisons;
    }

    /**
     * Returns the total number of swaps.
     * @return the number of swaps
     */
    public long getSwaps() {
        return swaps;
    }

    /**
     * Returns the total number of array accesses.
     * @return the number of array accesses
     */
    public long getArrayAccesses() {
        return arrayAccesses;
    }

    /**
     * Returns the total number of memory allocations.
     * @return the number of memory allocations
     */
    public long getMemoryAllocations() {
        return memoryAllocations;
    }

    /**
     * Returns the execution time in nanoseconds.
     * @return the time difference between start and end in nanoseconds
     */
    public long getExecutionTime() {
        if (startTime == 0 || endTime == 0) {
            return 0;
        }
        return endTime - startTime;
    }

    /**
     * Saves performance metrics to a CSV file.
     * Appends a new row with input size and all metrics. Adds header if the file is new.
     * @param filename the name of the CSV file
     * @param inputSize the size of the input (e.g., array length)
     */
    public void saveToCSV(String filename, int inputSize) {
        boolean isNewFile = !new java.io.File(filename).exists();
        try (java.io.FileWriter writer = new java.io.FileWriter(filename, true)) {
            // Add header if the file is new
            if (isNewFile) {
                writer.append("size,comparisons,swaps,arrayAccesses,memoryAllocations,executionTimeNs\n");
            }
            // Append data row with explicit newline
            writer.append(String.format("%d,%d,%d,%d,%d,%d\n",
                    inputSize,
                    comparisons,
                    swaps,
                    arrayAccesses,
                    memoryAllocations,
                    getExecutionTime()));
        } catch (java.io.IOException e) {
            System.err.println("Error writing to CSV file '" + filename + "': " + e.getMessage());
        }
    }
}