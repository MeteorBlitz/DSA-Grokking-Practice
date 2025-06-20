package a_warmup;

/*
 Problem: Square Root of a Non-negative Integer (Floor)
 Pattern: Warmup / Binary Search
 Status: ✅ Solved
 Input: x = 8
 Output: 2
 Explanation: √8 = 2.828..., so floor is 2
 Source: Warmup Practice
*/

public class SquareRoot {

    public static int mySqrt(int x) {
        if (x < 2) return x;

        int left = 1, right = x / 2;
        int result = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Use long to prevent integer overflow
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                result = mid;      // Update result and move right
                left = mid + 1;
            } else {
                right = mid - 1;   // Too big, move left
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));  // 2
        System.out.println(mySqrt(4));  // 2
        System.out.println(mySqrt(2));  // 1
        System.out.println(mySqrt(1));  // 1
        System.out.println(mySqrt(0));  // 0
    }
}
