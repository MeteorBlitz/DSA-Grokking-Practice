package a_warmup;

/*
 Problem: Count Good Pairs in an Integer Array
 Pattern: Warmup / Hashing
 Status: ✅ Solved
 Input: nums = [1,2,3,1,1,3]
 Output: 4
 Explanation: Good pairs are (0,3), (0,4), (3,4), (2,5)
 Source: Warmup Practice
*/

import java.util.*;

public class GoodPairsCounter {

    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            // If num is already seen, add its current frequency to the count
            if (freq.containsKey(num)) {
                count += freq.get(num);
            }

            // Increase frequency of current number
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3})); // 4
        System.out.println(numIdenticalPairs(new int[]{1, 1, 1, 1}));       // 6
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3}));          // 0
    }
}
