package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Min_Window_Substring_76 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> existence = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char character = t.charAt(i);
            existence.put(character, existence.getOrDefault(character, 0) + 1);
        }

        Map<Character, Integer> occurrences = new HashMap<>();
        String minSubstring = s + "-";

        int startIndex = 0;
        var totalFoundCharacters = 0;
        var totalCharactersExorbitanceToMatch = existence.keySet().size();

        for (int i = startIndex; i < s.length(); i++) {
            Character character = s.charAt(i);
            var isRelevantCharacter = existence.containsKey(character);

            if (isRelevantCharacter) {
                occurrences.put(character, occurrences.getOrDefault(character, 0) +1);
                var reachedValidAmountOfThatCharacter = Objects.equals(existence.get(character), occurrences.get(character));
                if (reachedValidAmountOfThatCharacter) {
                    totalFoundCharacters++;
                }
            }

            if (totalFoundCharacters == totalCharactersExorbitanceToMatch && minSubstring.length() > i - startIndex) {
                    minSubstring = s.substring(startIndex, i + 1);
            }

            while (totalFoundCharacters == totalCharactersExorbitanceToMatch) {
                var characterExtracted = s.charAt(startIndex);
                startIndex++;
                var isRelevant = existence.containsKey(characterExtracted);
                var stillValidAmountOfThatCharacter = true;
                if (isRelevant) {
                    occurrences.put(characterExtracted, occurrences.get(characterExtracted) - 1);
                    stillValidAmountOfThatCharacter = existence.get(characterExtracted) <= occurrences.get(characterExtracted);
                    if (!stillValidAmountOfThatCharacter){
                        totalFoundCharacters--;
                    }
                }
                if (stillValidAmountOfThatCharacter && minSubstring.length() > i -startIndex) {
                    minSubstring = s.substring(startIndex, i + 1);
                }
            }

        }

        return minSubstring.length() <= s.length() ? minSubstring : "";
    }
}