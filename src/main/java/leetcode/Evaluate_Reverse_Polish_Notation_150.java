package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Evaluate_Reverse_Polish_Notation_150 {
    Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
        var stack = new java.util.Stack<Integer>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                var b = stack.pop();
                var a = stack.pop();
                stack.push(operate(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private int operate(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}
