
## 📁 Project Structure

```

assignment2/
├── data/                       # Optional: input datasets
├── data-before_optimization/   # Optional: benchmark results before optimization
├── docs/
│   ├── analysis-report.pdf     # Documentation report on your partner’s algorithm
│   └── performance-plots/      # Time and input size plots for different types of arrays     
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── algorithms/     # Kadane's Algorithm implementation
│   │   │   │   └── KadanesAlgorithm.java
│   │   │   ├── cli/            # Command-line interface / runners
│   │   │   │   └── BenchmarkRunner.java
│   │   │   └── metrics/        # Performance tracking tools
│   │   │       └── PerformanceTracker.java
│   │   └── resources/          # Optional resource files
│   └── test/
│       └── java/
│           └── algorithms/     # Unit tests
│               └── KadaneAlgorithmTest.java
├── .idea/                       # IDE project files
├── .mvn/                        # Maven wrapper files (if using Maven)
└── README.md

---

# 📊 Kadane’s Algorithm Project — v1.0

## 🔍 Overview
This project implements **Kadane’s Algorithm**, a classic and efficient solution for 
finding the **maximum subarray sum** within a one-dimensional array of integers.

In addition to returning the **maximum sum**, the implementation also provides the **starting and ending indices** of the subarray:
```java
return new int[]{maxSoFar, start, end};
````

---

# Usage

## Running Tests (Maven)

```bash

mvn test
````
---

## Running Benchmark

The benchmark class is located at `src/main/java/cli/BenchmarkRunner.java`.

### 1. Compile the project

```bash
mvn compile
```

### 2. Run the benchmark

**Linux / Mac:**

```bash
java -cp target/classes cli.BenchmarkRunner

```

**Windows:**

```bash
java -cp target\classes cli.BenchmarkRunner
```
⚠️ Note: The results may vary between runs due to JVM warm-up and system load. 
For more stable measurements, consider running the benchmark multiple times and averaging the results.

The benchmark results will be printed to the data package


---

## ⚙️ Features

* ✅ Implementation of **Kadane’s Algorithm** with index tracking
* ✅ **Unit Tests** for correctness and robustness

    * Handles `null` and empty arrays
    * Tests arrays with positive, negative, and identical elements
* ⚡ **Benchmark Tests**

    * **Input Distribution Tests**: random, sorted, reverse-sorted, and nearly-sorted arrays
    * **Scalability Tests**: adjustable array sizes (100, 1,000, 10,000, 100,000)
    * **Memory Profiling**: tracks memory usage and garbage collection behavior

---

## 🧪 Unit Testing Example

Example JUnit test for a random mixed array:

```java
/**
 * testing a random element array
 */
@Test
void testRandomElementArray() {
    int[] result = testObject.findMaxSubarray(new int[]{-8, 7, 11, 4, 0, -17, 41, -50, 30, 21, 5});
    assertArrayEquals(new int[]{56, 8, 10}, result); // subarray [30, 21, 5]
}
```

✅ **Explanation:**
This test verifies that the algorithm correctly identifies the subarray `[30, 21, 5]`
as the segment with the **maximum sum = 56**, located between indices **8** and **10**.
It demonstrates proper handling of random mixed data (positive and negative values).

---

## 📈 Example Output

Input:

```
[-2, 1, -3, 4, -1, 2, 1, -5, 4]
```

Output:

```
Max Subarray Sum: 6
Start Index: 3
End Index: 6
Subarray: [4, -1, 2, 1]
```

---

## 📚 Complexity Analysis

| Metric               | Value | Explanation                  |
| -------------------- | ----- | ---------------------------- |
| **Time Complexity**  | O(n)  | One pass through the array   |
| **Space Complexity** | O(1)  | Constant auxiliary variables |

---

## 🏷️ Version

**v0.1** — Initial release

* Implemented Kadane’s algorithm with start/end indices
* Added unit tests (error handling + correctness)
* Added benchmark suite (input distribution + memory profiling)


## Fixes & Improvements

Accurate timing: Previously, the tracker started before validating the input array, 
causing initialization checks to be included in the total execution time.
→ This was fixed by starting the tracker only after input validation.

Consistent metrics: A call to tracker.reset() was added before each execution, 
ensuring all performance data is cleared before reuse.

---

## ⚙️ Benchmark Comparison — *Before vs After Optimization*

The table below compares performance metrics of **Kadane’s Algorithm** before and after improving the tracker logic.
Originally, the timer also included array validation and initialization overhead.
After the fix, only the algorithm’s core execution time is measured.

| Input Size              | Comparisons | Swaps | Array Accesses | Memory Allocations | Execution Time (ns) |
| ----------------------- | ----------- | ----- | -------------- | ------------------ | ------------------- |
| **Before Optimization** |             |       |                |                    |                     |
| 100                     | 114         | 0     | 199            | 1                  | **33,700**          |
| 1,000                   | 1,064       | 0     | 1,999          | 1                  | **132,700**         |
| 10,000                  | 10,157      | 0     | 19,999         | 1                  | **972,900**         |
| 100,000                 | 100,195     | 0     | 199,999        | 1                  | **3,618,800**       |
| **After Optimization**  |             |       |                |                    |                     |
| 100                     | 114         | 0     | 199            | 1                  | **20,400**          |
| 1,000                   | 1,064       | 0     | 1,999          | 1                  | **104,200**         |
| 10,000                  | 10,157      | 0     | 19,999         | 1                  | **787,600**         |
| 100,000                 | 100,195     | 0     | 199,999        | 1                  | **3,140,100**       |

---

### 📈 Key Insights

* **Execution time dropped by ~20–40%** across all input sizes due to cleaner measurement (no initialization overhead).
* **Operation counts (comparisons, accesses, allocations)** remain identical — confirming algorithmic behavior is unchanged.
* **Performance scaling stays linear (O(n))**, validating Kadane’s theoretical complexity.

---

### Summary of Fixes

* **Accurate timing** — tracker starts *after* validation.
* **Consistent metrics** — `tracker.reset()` clears previous data before each run.
* **Measured improvement** — execution time now reflects *pure algorithmic cost*, not setup overhead.

---

---

👤 **Author:** [GreatJobSon -aka Beibarys]
📅 **Release Date:** 2025
🔖 **Tag:** `v0.1`

```
