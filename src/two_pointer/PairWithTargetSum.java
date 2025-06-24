package two_pointer;

/*
 Problem: Pair with Target Sum
 Pattern: Two Pointers
 Status: ✅ Solved
 Input: nums = [1, 2, 3, 4, 6], target = 6
 Output: [1, 3]
 Explanation: The numbers at index 1 and 3 add up to 6: 2 + 4 = 6
 Source: Grokking the Coding Interview
*/

public class PairWithTargetSum {

    public static int[] search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                return new int[] { left, right };
            }

            if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { -1, -1 }; // No pair found
    }

    public static void main(String[] args) {
        int[] result1 = search(new int[] {1, 2, 3, 4, 6}, 6);
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]");

        int[] result2 = search(new int[] {2, 5, 9, 11}, 11);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]");
    }
}

