package Must50_Interview_Programs;

/*
 No. 02
 Problem: FizzBuzz
 Pattern: Warmup / Looping
 Status: ✅ Solved
 Input: n = 5
 Output: ["1", "2", "Fizz", "4", "Buzz"]
 Explanation: Multiples of 3 → "Fizz", of 5 → "Buzz", both → "FizzBuzz"
 Source: LeetCode #412
*/

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) result.add("FizzBuzz");
            else if (i % 3 == 0) result.add("Fizz");
            else if (i % 5 == 0) result.add("Buzz");
            else result.add(String.valueOf(i));
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 15;
        List<String> output = fizzBuzz(n);
        for (String s : output) {
            System.out.println(s + " ");
        }
    }
}