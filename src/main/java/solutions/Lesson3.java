package solutions;

import java.util.Arrays;

public class Lesson3 {
    public int FrogJmp(int X, int Y, int D){
        return Y== X ? 0 : (int) Math.ceil((Y - X) / (double)D);
    }

    public int PermMissingElem(int[] A){
        Arrays.sort(A);
        for (int i = 1; i < A.length + 1 ; i++) {
            if (A[i - 1] != i){
                return i;
            }
        }

        return A.length + 1;
    }

    public int TapeEquilibrium(int[] A){
        int[] sums = new int[A.length];
        sums[0] = A[0];

        for (int i = 1; i < A.length ; i++) {
            sums[i] = sums[i-1] + A[i];
        }

        int totalSum = sums[sums.length-1];
        int minDifference = Integer.MAX_VALUE;

        for (int i = A.length - 1; i > 0 ; i--) {
            int leftPart = sums[i-1];
            int rightPart = totalSum - leftPart;
            int difference = Math.abs(rightPart - leftPart);
            if (minDifference > difference){
                minDifference = difference;
            }
        }

        return minDifference;
    }
}
