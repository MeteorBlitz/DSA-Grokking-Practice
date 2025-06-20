package a_warmup;

/*
 Problem: Shortest Distance Between Two Words in a List
 Pattern: Warmup / Two Pointers
 Status: ✅ Solved
 Input: words = ["a", "c", "d", "b", "a"], word1 = "a", word2 = "b"
 Output: 1
 Explanation: "a" at index 4 and "b" at index 3 → distance = 1
 Source: Warmup Practice
*/

public class ShortestWordDistance {

    public static int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int minDistance = Integer.MAX_VALUE;

        // Traverse the list once
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }

            // If both words found, calculate distance
            if (index1 != -1 && index2 != -1) {
                int dist = Math.abs(index1 - index2);
                minDistance = Math.min(minDistance, dist);
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        String[] words1 = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String[] words2 = {"a", "c", "d", "b", "a"};

        System.out.println(shortestDistance(words1, "fox", "dog")); // 5
        System.out.println(shortestDistance(words2, "a", "b"));      // 1
    }
}
