package two_pointer;

/*
 Problem: Triplet Sum to Zero
 Pattern: Two Pointers
 Status: ✅ Solved
 Input: nums = [-3, 0, 1, 2, -1, 1, -2]
 Output: [[-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]]
 Explanation: There are four unique triplets whose sum is 0
 Source: Grokking the Coding Interview
*/

import java.util.*;

public class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            // Skip duplicates
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int left = i + 1, right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    triplets.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right && arr[left] == arr[left - 1]) left++;
                    while (left < right && arr[right] == arr[right + 1]) right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        System.out.println("Output: " + searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println("Output: " + searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }
}
