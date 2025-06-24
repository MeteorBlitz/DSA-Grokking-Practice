package two_pointer;

/*
 Problem: Triplets with Smaller Sum
 Pattern: Two Pointers
 Status: ✅ Solved
 Input: nums = [-1, 0, 2, 3], target = 3
 Output: 2
 Explanation: Valid triplets are [-1, 0, 2] and [-1, 0, 3]
 Source: Grokking the Coding Interview
*/

import java.util.Arrays;

public class TripletsWithSmallerSum {

    public static int countTriplets(int[] arr, int target) {
        Arrays.sort(arr);  // Step 1: Sort the array
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum < target) {
                    // All triplets from left to right-1 are valid
                    count += (right - left);
                    left++;  // Try next left
                } else {
                    right--;  // Try smaller right
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("Output: " + countTriplets(new int[]{-1, 0, 2, 3}, 3)); // 2
        System.out.println("Output: " + countTriplets(new int[]{-1, 4, 2, 1, 3}, 5)); // 4
    }
}
