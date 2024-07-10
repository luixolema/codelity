package leetcode;

public class Plus_One_66 {
    public int[] plusOne(int[] digits) {
        var incrementArrayLength = false;
        var increment = true;
        for (int i = digits.length - 1; i >= 0 && increment; i--) {
            var digit = digits[i];
            if (digit == 9) {
                digits[i] = 0;
                increment = true;
            } else {
                digits[i] = digit + 1;
                increment = false;
            }
            if (i == 0 && increment) {
                incrementArrayLength = true;
            }
        }

        if (incrementArrayLength){
            int[] newArray = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                newArray[i + 1] = digits[i];
            }
            newArray[0] = 1;
            digits = newArray;
        }

        return digits;
    }
}
