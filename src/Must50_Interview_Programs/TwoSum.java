package Must50_Interview_Programs;

/*
 No. 01
 Problem: Two Sum
 Pattern: Hashing
 Status: ✅ Solved
 Input: nums = [2, 7, 11, 15], target = 9
 Output: [0, 1]
 Explanation: nums[0] + nums[1] = 2 + 7 = 9
 Source: LeetCode #1
*/

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // not found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}