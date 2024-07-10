package leetcode;

import java.util.*;

public class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        var map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');


        var stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("({[".contains(""+c)){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }

                Character peek = stack.pop();
                if (peek != map.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}