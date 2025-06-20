package a_warmup;

/*
 Problem: Valid Anagram (Check if Two Strings Are Anagrams)
 Pattern: Warmup / Hashing
 Status: ✅ Solved
 Input: s = "listen", t = "silent"
 Output: true
 Explanation: Both strings use the same letters in different order
 Source: Warmup Practice
*/

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        // If lengths are different, not an anagram
        if (s.length() != t.length()) return false;

        // Frequency array for 26 lowercase letters
        int[] freq = new int[26];

        // Count frequency of each character in s
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Subtract frequency using characters in t
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0) return false; // Early exit
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent")); // true
        System.out.println(isAnagram("rat", "car"));        // false
        System.out.println(isAnagram("hello", "world"));    // false
    }
}

