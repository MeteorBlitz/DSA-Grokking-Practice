package a_warmup;

/*
 Problem: Reverse Vowels of a String
 Pattern: Warmup / Two Pointers
 Status: ✅ Solved
 Input: s = "DesignGUrus"
 Output: "DusUgnGires"
 Explanation: All vowels (e, i, U, u) are reversed, rest remain same
 Source: Warmup Practice
*/

import java.util.*;

public class ReverseVowels {

    public static String reverseVowels(String s) {
        // Convert string to char array for swapping
        char[] chars = s.toCharArray();

        // Set of vowels (both lowercase and uppercase)
        Set<Character> vowels = new HashSet<>(
                Arrays.asList('a','e','i','o','u','A','E','I','O','U')
        );

        // Two pointers
        int left = 0;
        int right = s.length() - 1;

        // Process until the pointers meet
        while (left < right) {
            // Move left until a vowel is found
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            // Move right until a vowel is found
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // Move pointers
            left++;
            right--;
        }

        // Convert char array back to string
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));        // holle
        System.out.println(reverseVowels("AEIOU"));        // UOIEA
        System.out.println(reverseVowels("DesignGUrus"));  // DusUgnGires
    }
}
