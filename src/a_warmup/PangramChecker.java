package a_warmup;

import java.util.HashSet;
import java.util.Set;

/*
 Problem: Check if Sentence is a Pangram
 Pattern: Warmup / Hashing
 Status: ✅ Solved
 Input: sentence = "TheQuickBrownFoxJumpsOverTheLazyDog"
 Output: true
 Explanation: Sentence contains every letter from 'a' to 'z'
 Source: Warmup Practice
*/

public class PangramChecker {

    public static boolean isPangram(String sentence) {
        // Convert the sentence to lowercase to ignore case sensitivity
        sentence = sentence.toLowerCase();

        // Use a Set to store unique characters
        Set<Character> letters = new HashSet<>();

        // Add only letters to the Set
        for (char ch : sentence.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                letters.add(ch);
            }
        }

        // Check if we have all 26 letters
        return letters.size() == 26;
    }

    // Main method to test
    public static void main(String[] args) {
        String test1 = "TheQuickBrownFoxJumpsOverTheLazyDog";
        String test2 = "This is not a pangram";

        System.out.println(isPangram(test1)); // true
        System.out.println(isPangram(test2)); // false
    }
}