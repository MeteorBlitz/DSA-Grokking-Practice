package two_pointer;

/*
 Problem: Dutch National Flag Problem
 Pattern: Two Pointers
 Status: ✅ Solved
 Input: arr = [1, 0, 2, 1, 0]
 Output: [0, 0, 1, 1, 2]
 Explanation: All 0s are moved to the front, 1s in the middle, and 2s at the end.
             Sorting is done in-place without counting or extra space.
 Source: Grokking the Coding Interview
*/

import java.util.Arrays;

public class DutchNationalFlag {

    public static void sortColors(int[] arr) {
        int low = 0, high = arr.length - 1;
        int i = 0;

        while (i <= high) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else { // arr[i] == 2
                swap(arr, i, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 2, 1, 0};
        sortColors(arr1);
        System.out.println("Output: " + Arrays.toString(arr1)); // [0, 0, 1, 1, 2]

        int[] arr2 = {2, 2, 0, 1, 2, 0};
        sortColors(arr2);
        System.out.println("Output: " + Arrays.toString(arr2)); // [0, 0, 1, 2, 2, 2]
    }
}
