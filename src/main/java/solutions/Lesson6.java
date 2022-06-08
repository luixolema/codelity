package solutions;

import javax.swing.plaf.SpinnerUI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson6 {

    public int Distinct(int[] A) {
        HashSet<Integer> set = new HashSet<>();

        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            if (set.add(A[i])) {
                counter++;
            }
        }

        return counter;
    }

    public int MaxProductOfThree(int[] A) {
        Arrays.sort(A);
        int maxElementsProduct = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];

        // in case those are negative and their product is bigger than the maxElements product ex:
        // [-5,-4,-3,-2,1],[-5,-4,-3,1,2]
        // in the special case of all of them are negative them the max elements products will be the correct answer: ex: [-5,-4,-3,-2,-1]

        int mintElementsProduct = A[0] * A[1];
        return Integer.max(mintElementsProduct * A[A.length - 1], maxElementsProduct);
    }

    public int Triangle(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            if (((long) A[i] + A[i + 1]) > A[i + 2]) {
                return 1;
            }
        }

        return 0;
    }

    public int NumberOfDiscIntersections(int[] A) {
        int result = 0;

        int[] openPositions = new int[A.length];
        int[] closePositions = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            openPositions[i] = i - A[i];
            closePositions[i] = i + A[i];
        }

        Arrays.sort(openPositions);
        Arrays.sort(closePositions);

        int openPositionIndex = 0;
        int closePositionIndex = 0;
        int previousOpenCircles = 0;

        while (openPositionIndex < openPositions.length) {
            int open = openPositions[openPositionIndex];
            int close = closePositions[closePositionIndex];

            if (open < close) {
                // a circle is opened
                openPositionIndex++;
                previousOpenCircles++;
            } else if (open == close) {
                // a circle is opened
                previousOpenCircles++;
                openPositionIndex++;
            } else {
                // a circle is closed
                previousOpenCircles--;
                result += previousOpenCircles;
                closePositionIndex++;
            }

            if (result > 10000000) {
                return -1;
            }
        }

        while (closePositionIndex < closePositions.length) {
            // a circle is closed
            closePositionIndex++;
            previousOpenCircles--;
            result += previousOpenCircles;

            if (result > 10000000) {
                return -1;
            }
        }

        return result;
    }
}
