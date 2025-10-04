package cli;

import java.util.Scanner;

/**
 * A command-line interface for benchmarking Kadane's Algorithm with configurable input sizes.
 * Executes benchmarks on user-provided sizes or defaults to a predefined set if none are specified.
 */
public class BenchmarkRunner {
    // Default sizes for testing if no arguments are provided
    private static final int[] DEFAULT_SIZES = {100, 1000, 10000, 100000};

    /**
     * Main entry point to run the benchmark with specified or default sizes.
     * @param args command-line arguments representing input sizes
     */
    public static void main(String[] args) {
        // Parse input sizes from command-line arguments

        int[] sizes = parseInputSizes(args);

        // Use default sizes if no valid arguments provided
        if (sizes == null) {
            System.out.println("Enter the array sizes separated by a space and press Enter:");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String[] input = line.trim().split("\\s+");
            sizes = parseInputSizes(input);
            if (sizes == null) {
                sizes = DEFAULT_SIZES;
            }
        }
        // Run benchmarks for each size
        for (int size : sizes) {
            runBenchmark(size);
        }
    }

    /**
     * Parses command-line arguments into an array of integer sizes.
     * Returns null if arguments are invalid or empty.
     * @param args command-line arguments
     * @return array of parsed sizes or null if invalid
     */
    private static int[] parseInputSizes(String[] args) {
        if (args.length == 0) return null;
        int[] sizes = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                sizes[i] = Integer.parseInt(args[i]);
                if (sizes[i] <= 0) {
                    return null;
                }
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return sizes;
    }

    /**
     * Executes a benchmark for a given array size.
     * Generates a random array, runs Kadane's Algorithm, and saves results to CSV.
     * The benchmark results are saved in the data package
     * @param size the size of the input array
     */
    private static void runBenchmark(int size) {
        // Generate random test array
        int[] arr = generateRandomArray(size);
        algorithms.KadanesAlgorithm algorithm = new algorithms.KadanesAlgorithm();
        metrics.PerformanceTracker tracker = algorithm.getPerformanceTracker();

        // Run the algorithm
        int[] result = algorithm.findMaxSubarray(arr);

        // Save results to CSV
        tracker.saveToCSV("data/benchmark_results.csv", size);
    }

    /**
     * Generates a random array of the specified size with values between -50 and 49.
     * Uses a fixed seed for reproducibility.
     * @param size the size of the array to generate
     * @return the generated random array
     */
    private static int[] generateRandomArray(int size) {
        java.util.Random rand = new java.util.Random(42); // Fixed seed for reproducibility
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100) - 50; // Random numbers from -50 to 49
        }
        return arr;
    }
}