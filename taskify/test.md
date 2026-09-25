
# Make an array

- **Platform:** HackerEarth
- **Difficulty:** Easy
- **Track:** Algorithms / Searching / Linear Search
- **Problem Link:** [Make an array](https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/make-an-array-85abd7ad/)

## Problem Description
You are given an array A of length N. You take an array B of length N such that \(B[i] = 0\) for each 1 ≤ i ≤ N. 

You can apply the following operation on B any number of times:
- Choose (N - 1) distinct indices and add 1 to each of those indices.

**Task:** Find the number of operations required to convert array B into array A by applying the given operation. Print `-1` if it is impossible to do so.

## Approach
1. Each operation increments N - 1 elements by 1, which means the total sum of array elements increases by N - 1 in each operation.
2. Therefore, the sum of all elements in A must be divisible by N - 1. If `sum(A) % (N - 1) != 0`, it is impossible, so return `-1`.
3. The number of operations `k` would be `sum(A) // (N - 1)`.
4. In each operation, we can leave at most one element un-incremented. Thus, no element in A can be strictly greater than the total number of operations `k`.
5. If any element `A[i] > k`, it is impossible to form that value, so return `-1`. Otherwise, return `k`.

## Solution (Python 3)

```python
def solve(N, A):
    total_sum = sum(A)
    max_element = max(A)
    
    # Each operation increases the sum by N - 1
    if total_sum % (N - 1) != 0:
        return -1
        
    k = total_sum // (N - 1)
    
    # No element can be greater than the total number of operations k
    if k >= max_element:
        return k
    else:
        return -1

# Input processing
if __name__ == "__main__":
    N = int(input())
    A = list(map(int, input().split()))
    out_ = solve(N, A)
    print(out_)
```
