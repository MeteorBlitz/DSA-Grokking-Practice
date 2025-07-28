package Must50_Interview_Programs;

/*
 No. 04
 Problem: Find Kth Largest Element in Array
 Pattern: Heap / PriorityQueue / Min-Heap
 Status: ✅ Solved
 Input: nums = [3, 2, 3, 1, 2, 4, 5, 5, 6], k = 4
 Output: 4
 Explanation: Sorted order = [1, 2, 2, 3, 3, 4, 5, 5, 6]
              4th largest = 4
 Edge Cases: nums.length < k → return -1 (invalid), k=1 → max element
 Source: LeetCode #215 (Kth Largest Element in an Array)
*/

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) return -1;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest
            }
        }
        return minHeap.peek(); // kth largest
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int result = findKthLargest(nums, k);
        System.out.println("Kth Largest Element: " + result); // Output: 4
    }
}

