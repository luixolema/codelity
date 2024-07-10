package codelity;

import java.util.Stack;

public class Lesson7 {
    public int Brackets(String S) {
        if (S.length() == 0) {
            return 1;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            Character character = S.charAt(i);
            if (character.equals('(') || character.equals('[') || character.equals('{')) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }

                Character opened = stack.pop();
                if (opened.equals('(') && !character.equals(')')) {
                    return 0;
                }
                if (opened.equals('[') && !character.equals(']')) {
                    return 0;
                }
                if (opened.equals('{') && !character.equals('}')) {
                    return 0;
                }
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }

    public int Fish(int[] A, int[] B) {
        int survivors = 0;

        Stack<Integer> fishGoingLeft = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 0) { // going right
                if (fishGoingLeft.isEmpty()) {
                    survivors++;
                    continue;
                } else {
                    survivors += fight(A[i], fishGoingLeft);
                }
            } else { // going left
                fishGoingLeft.push(A[i]);
            }
        }

        while (!fishGoingLeft.isEmpty()) {
            survivors++;
            fishGoingLeft.pop();
        }

        return survivors;
    }

    private int fight(int fishGoingRightSize, Stack<Integer> fishGoingLeft) {
        while (fishGoingRightSize >= 0 && !fishGoingLeft.isEmpty()) {
            int fishGoingLeftSize = fishGoingLeft.peek();

            if (fishGoingRightSize > fishGoingLeftSize) {
                fishGoingLeft.pop();
            } else {
                fishGoingRightSize = -1;
            }
        }

        if (fishGoingRightSize >= 0) {
            return 1;
        }

        return 0;
    }

    public int Nesting(String S){
        return this.Brackets(S);
    }

    public int StoneWall(int[] H){
        Stack<Integer> previousCommonBlocks = new Stack<>();
        previousCommonBlocks.push(H[0]);

        int totalBlocks = 1;

        for (int i = 1; i < H.length; i++) {
            int block = H[i];

            if (previousCommonBlocks.isEmpty()){
                previousCommonBlocks.push(block);
                continue;
            }

            if (block > previousCommonBlocks.peek()){
                previousCommonBlocks.push(block);
                totalBlocks++;
            }

            if (block < previousCommonBlocks.peek()){
                while (!previousCommonBlocks.isEmpty() && block < previousCommonBlocks.peek()){
                    previousCommonBlocks.pop();
                }

                if (previousCommonBlocks.isEmpty() || block > previousCommonBlocks.peek()){
                    totalBlocks++;
                    previousCommonBlocks.push(block);
                }
            }


        }

        return totalBlocks;
    }
}
