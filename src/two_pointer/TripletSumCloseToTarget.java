package two_pointer;

/*
 Problem: Triplet Sum Close to Target
 Pattern: Two Pointers
 Status: ✅ Solved
 Input: nums = [-1, 0, 2, 3], target = 3
 Output: 2
 Explanation: The triplet [-1, 0, 3] has the sum '2' which is closest to the target.
            Among multiple close sums, we pick the one with the smaller value.
 Source: Grokking the Coding Interview
*/

import java.util.Arrays;

public class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                int targetDiff = targetSum - currentSum;

                if (targetDiff == 0) {
                    return targetSum; // Found exact match
                }

                // Check for closest sum
                if (Math.abs(targetDiff) < Math.abs(smallestDiff) ||
                        (Math.abs(targetDiff) == Math.abs(smallestDiff) && targetDiff > smallestDiff)) {
                    smallestDiff = targetDiff;
                }

                if (targetDiff > 0) {
                    left++; // Need a bigger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }

        return targetSum - smallestDiff;
    }

    public static void main(String[] args) {
        System.out.println("Output: " + searchTriplet(new int[]{-1, 0, 2, 3}, 3)); // 2
        System.out.println("Output: " + searchTriplet(new int[]{-3, -1, 1, 2}, 1)); // 0
        System.out.println("Output: " + searchTriplet(new int[]{1, 0, 1, 1}, 100)); // 3
        System.out.println("Output: " + searchTriplet(new int[]{0, 0, 1, 1, 2, 6}, 5)); // 4
    }
}
