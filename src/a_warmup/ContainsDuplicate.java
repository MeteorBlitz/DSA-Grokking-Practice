package a_warmup;

/*
 Problem: Check if Array Contains Duplicates
 Pattern: Warmup / Hashing
 Status: ✅ Solved
 Input: nums = [1, 2, 3, 4]
 Output: false
 Explanation: No duplicates in the array
 Source: Warmup Practice
*/


import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Duplicate found
            }
            seen.add(num);
        }
        return false; // No duplicates
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println("Has Duplicate: " + hasDuplicate(nums));
    }
}

