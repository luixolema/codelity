package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();

        for (String str : strs) {
            var key = Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                var list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
