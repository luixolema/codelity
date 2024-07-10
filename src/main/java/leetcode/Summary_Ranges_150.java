package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges_150 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0){
            return result;
        }

        var start = nums[0];
        var end = nums[0];
        var search = nums[0]+1;

        int current = 0;

        for (int i = 1; i < nums.length; i++) {
            current = nums[i];
            if (current == search){
                search++;
                end = current;
                if (i == nums.length-1){
                    result.add(start + "->"+ end);
                }
            }else {
                if (start == end) {
                    result.add(String.valueOf(start));
                }else{
                    result.add(start + "->"+ end);
                }
                start = current;
                end = current;
                search = start + 1;
            }
        }

        if (start == end){
            result.add(String.valueOf(start));
        }
        return result;
    }
}
