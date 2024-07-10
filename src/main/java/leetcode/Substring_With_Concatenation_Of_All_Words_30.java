package leetcode;

import java.util.*;

public class Substring_With_Concatenation_Of_All_Words_30 {

    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int wordCount = words.length;
        int substringLength = wordCount * wordLength;

        Map<String, Integer> existence = new HashMap<>();
        for (String word : words) {
            existence.put(word, existence.getOrDefault(word,0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <wordLength; i++) {
            int startIndex = i;
            while (startIndex < s.length() - substringLength) {
                var endIndex = startIndex + substringLength;
                if (isSubstring(s, startIndex, endIndex, wordLength, existence)) {
                    result.add(startIndex);
                }
                startIndex+=wordLength;
            }
        }


        return result;
    }

    private boolean isSubstring(String text, int startIndex, int endIndex, int wordLength, Map<String, Integer> existence) {
        Map<String, Integer> occurrences = new HashMap<>();

        for (int i = startIndex; i < endIndex; i += wordLength) {
            String word = text.substring(i, i + wordLength);
            occurrences.put(word, occurrences.getOrDefault(word, 0) + 1);
            if (existence.get(word) == null || occurrences.get(word) > existence.get(word)) {
                return false;
            }
        }

        return true;
    }
}
