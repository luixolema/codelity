package leetcode;

import java.util.HashSet;

public class Longest_Consecutive_Sequence_180 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }


        var maxConsecutiveSequence = 1;
        for (int num : set) {
            var startASequence = !set.contains(num - 1);
            if (startASequence) {
                var count = 1;
                while (set.contains(num + count)) {
                    count++;
                }
                maxConsecutiveSequence = Math.max(maxConsecutiveSequence, count);
            }
        }

        return maxConsecutiveSequence;
    }
}
