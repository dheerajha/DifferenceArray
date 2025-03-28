# Difference Array - The Ultimate Guide

## 🔍 What is a Difference Array?
A **Difference Array** is a powerful technique used for efficiently performing range update queries on an array. It allows multiple increment/decrement operations in **O(1)** time per update and reconstructs the final array in **O(N)** time.

## 🚀 How Does a Difference Array Work?
Given an array **arr[]**, we construct a **difference array** `diff[]` such that:
- `diff[i] = arr[i] - arr[i-1]` (for `1 <= i < N`)
- Using `diff[]`, we can efficiently update a range `[l, r]` by incrementing `diff[l]` and decrementing `diff[r+1]`.
- Finally, we compute the prefix sum of `diff[]` to reconstruct the modified `arr[]`.

## 🛠️ Implementation of a Difference Array
### ✅ Constructing and Using a Difference Array
```cpp
#include <bits/stdc++.h>
using namespace std;

void applyDifferenceArray(vector<int>& arr, vector<vector<int>>& updates) {
    int n = arr.size();
    vector<int> diff(n + 1, 0);
    
    // Apply all updates
    for (auto& u : updates) {
        int l = u[0], r = u[1], val = u[2];
        diff[l] += val;
        diff[r + 1] -= val;
    }
    
    // Compute final values
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += diff[i];
        arr[i] += sum;
    }
}

int main() {
    vector<int> arr = {0, 0, 0, 0, 0};
    vector<vector<int>> updates = {{1, 3, 5}, {2, 4, 10}};
    applyDifferenceArray(arr, updates);
    for (int x : arr) cout << x << " ";
    return 0;
}
```

## 📌 Key Difference Array Applications & Problems

### 1️⃣ **Range Update Queries Efficiently**
- Instead of modifying each element individually in **O(N)** per update, use **O(1)** updates with difference array.
- **Example:** [Range Addition](https://leetcode.com/problems/range-addition/)

### 2️⃣ **Applying Multiple Updates at Once**
- Useful when applying multiple updates across an array efficiently.
- **Example:** [Applying Multiple Increment Updates](https://www.geeksforgeeks.org/difference-array-range-update-query-o1/)

### 3️⃣ **Prefix Sum with Difference Array**
- After updates, apply prefix sum to reconstruct the final array.
- **Example:** [Game of Numbers](https://www.codechef.com/problems/GNUM)

### 4️⃣ **Extending to 2D Difference Array**
- Used for efficiently updating submatrices in 2D arrays.
- **Example:** [Increment 2D Submatrices](https://leetcode.com/problems/increment-submatrices-by-one/)

---

## 🎯 Time Complexity Analysis
| Operation | Time Complexity |
|-----------|----------------|
| Constructing `diff[]` | **O(N)** |
| Range Update (Single) | **O(1)** |
| Applying All Updates | **O(N)** |
| Querying a Single Element | **O(1)** |

---

## 📚 More Practice Problems
1. [Range Addition (Leetcode)](https://leetcode.com/problems/range-addition/)
2. [Cumulative Frequency Table](https://www.spoj.com/problems/UPDATEIT/)
3. [Applying Multiple Updates in an Array](https://www.geeksforgeeks.org/difference-array-range-update-query-o1/)
4. [Finding Maximum Element After Updates](https://www.interviewbit.com/problems/beginners-problem/)  

---

## 🔥 Conclusion
The **Difference Array** is an optimized technique for handling multiple range updates efficiently. Understanding it well can help solve various range modification problems in competitive programming.

Happy Coding! 🚀

