package Must50_Interview_Programs;
/*
 No. 03
 Problem: Find Second Largest Number in Array
 Pattern: Array / One Pass / Max Tracking
 Status: ✅ Solved
 Input: [12, 5, 8, 19, 5, 17]
 Output: 17
 Explanation: 19 is the largest, and 17 is the next highest (second largest)
 Edge Cases: [10] → -1 (only one element), [10,10,10] → -1 (no second largest)
 Source: Custom / Similar to LeetCode #215 & #1796 (Kth Largest Element)
*/

public class SecondLargest {

    public static int findSecondLargest(int[] nums) {
        if (nums.length < 2) return -1; // not enough elements

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        return (second == Integer.MIN_VALUE) ? -1 : second;
    }

    public static void main(String[] args) {
        int[] nums = {12, 5, 8, 19, 5, 17};
        int result = findSecondLargest(nums);
        System.out.println("Second Largest: " + result);
    }
}
