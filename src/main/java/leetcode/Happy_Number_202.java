package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Happy_Number_202 {
    public boolean isHappy(int n) {
        var memo = new HashMap<Integer, Integer>();
        var set = new HashSet<Integer>();
        var numberToCheck = n;

        while (set.add(numberToCheck)) {
            String s = String.valueOf(numberToCheck);
            var sum = 0;

            for (int i = 0; i < s.length(); i++) {
                int digit = Integer.parseInt(""+ s.charAt(i));
                int square = memo.containsKey(digit) ? memo.get(digit) : digit * digit;
                memo.put(digit, square);
                sum += square;
            }

            if (sum == 1) {
                return true;
            }

            numberToCheck = sum;
        }

        return false;
    }
}
