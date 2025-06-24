package two_pointer;

/*
 Problem: Squaring a Sorted Array
 Pattern: Two Pointers
 Status: ✅ Solved
 Input: nums = [-2, -1, 0, 2, 3]
 Output: [0, 1, 4, 4, 9]
 Explanation: Squared values in sorted order
 Source: Grokking the Coding Interview
*/

import java.util.Arrays;

public class SortedSquares {

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int left = 0, right = n - 1;
        int highestIndex = n - 1;

        while (left <= right) {
            int leftSq = arr[left] * arr[left];
            int rightSq = arr[right] * arr[right];

            if (leftSq > rightSq) {
                squares[highestIndex--] = leftSq;
                left++;
            } else {
                squares[highestIndex--] = rightSq;
                right--;
            }
        }

        return squares;
    }

    public static void main(String[] args) {
        System.out.println("Output: " + Arrays.toString(makeSquares(new int[]{-2, -1, 0, 2, 3})));
        System.out.println("Output: " + Arrays.toString(makeSquares(new int[]{-3, -1, 0, 1, 2})));
    }
}
