package leetcode;

import java.util.Stack;

class Node3 {
    Integer val;
    boolean isAdding;

    Node3(Integer val, boolean isAdding){
        this.val = val;
        this.isAdding = isAdding;
    }

}

/**
 * we start with a 0 result and a boolean isAdding = true to keep track of the operation that we are doing.
 *
 * So after fining another number we know what to do, add or subtract the number to the result so far.
 *
 * In the case we find an open parenthesis we push the current result and the isAdding to a stack and reset the result and operator.
 *  - we compute the result inside the parenthesis
 *  - after fining the closing parenthesis:
 *     we pop the previous result and operator and continue with the computation:
 *      adding or subtracting the result (depending on what we had in the stack) inside the parenthesis to the previous result.
 * Because the initial result is set to 0 if we find "-" and then "1" (-1) that will be subtracted from the previous result (0) so we get the correct result.
 */

//"(1+(4+5+2)-3)+(6+8)"
public class BasicCalculator_224 {
    public int calculate(String s) {
        Stack<Node3> stack = new Stack<>();
        int result = 0;
        var isAdding = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                i--;
                int val = Integer.parseInt(s.substring(start, i + 1));
                result = isAdding ? result + val : result - val;
            } else if (c == '+') {
                isAdding = true;
            } else if (c == '-') {
                isAdding = false;
            } else if (c == '(') {
                stack.push(new Node3(result, isAdding));
                result = 0;
                isAdding = true;
            } else if (c == ')') {
                Node3 previous = stack.pop();
                result = previous.isAdding ? previous.val + result : previous.val - result;
            }
        }

        return result;
    }
}
