package a_warmup;

/*
 Problem: Valid Palindrome (Ignore Case and Non-Alphanumeric)
 Pattern: Warmup / Two Pointers
 Status: ✅ Solved
 Input: s = "A man, a plan, a canal, Panama!"
 Output: true
 Explanation: After cleaning → "amanaplanacanalpanama", which is a palindrome.
 Source: Warmup Practice
*/

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        // Convert to lowercase
        s = s.toLowerCase();

        // Two pointers
        int left = 0;
        int right = s.length() - 1;

        // Check characters from both ends
        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal, Panama!")); // true
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));    // true
        System.out.println(isPalindrome("No lemon, no melon!"));             // true
        System.out.println(isPalindrome("Hello World!"));                    // false
    }
}