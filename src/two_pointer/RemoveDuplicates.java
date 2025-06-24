package two_pointer;

/*
 Problem: Find Non-Duplicate Number Instances
 Pattern: Two Pointers
 Status: ✅ Solved
 Input: nums = [2, 3, 3, 3, 6, 9, 9]
 Output: 4
 Explanation: The first 4 elements after removing duplicates are [2, 3, 6, 9]
 Source: Grokking the Coding Interview
*/

public class RemoveDuplicates {

    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int nextNonDuplicate = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 3, 3, 6, 9, 9};
        int length1 = removeDuplicates(arr1);
        System.out.print("Output: " + length1 + "\n");

        int[] arr2 = {2, 2, 2, 11};
        int length2 = removeDuplicates(arr2);
        System.out.print("Output: " + length2 + "\n");
    }
}
