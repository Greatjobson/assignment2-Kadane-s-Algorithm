
---

````markdown
# 📊 Kadane’s Algorithm Project — v0.1

## 🔍 Overview
This project implements **Kadane’s Algorithm**, a classic and efficient solution for 
finding the **maximum subarray sum** within a one-dimensional array of integers.

In addition to returning the **maximum sum**, the implementation also provides the **starting and ending indices** of the subarray:
```java
return new int[]{maxSoFar, start, end};
````

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

---

👤 **Author:** [GreatJobSon -aka Beibarys]
📅 **Release Date:** 2025
🔖 **Tag:** `v0.1`

```
