package solutions;

public class Lesson5 {

    /**
     * This exercise is included in the documentation given as an attachment in the lesson
     */
    public int mushRoomPicker(int[] mushrooms, int pickerPosition, int possibleMovements) {
        int[] mushroomsPrefixSum = prefixSum(mushrooms);

        int allToLeft = sumInSlice(mushroomsPrefixSum, 0, pickerPosition);
        int allToRight = sumInSlice(mushroomsPrefixSum, pickerPosition, mushrooms.length - 1);
        int maxMushroomsPicked = Integer.max(allToLeft, allToRight);


        // possible movements to the left one by one (if its possible),
        // so we calculate all the going back - going forward possibilities.
        int movementToLeft = 1;
        while (movementToLeft * 2 < possibleMovements) {
            int indexToLeft = pickerPosition - movementToLeft;
            int movementsToRight = possibleMovements - movementToLeft * 2;
            int indexToRight = pickerPosition + movementsToRight;
            if ((pickerPosition - movementToLeft >= 0) && pickerPosition + movementsToRight < mushrooms.length) {
                int pickedMushrooms = sumInSlice(mushroomsPrefixSum, indexToLeft, indexToRight);
                if (pickedMushrooms > maxMushroomsPicked) {
                    maxMushroomsPicked = pickedMushrooms;
                }
            }
            movementToLeft++;
        }

        return maxMushroomsPicked;

    }

    private int[] prefixSum(int[] A) {
        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        return prefixSum;
    }

    private int sumInSlice(int[] prefixSumArray, int fromIndex, int toIndex) {
        if (fromIndex > 0) {
            return prefixSumArray[toIndex] - prefixSumArray[fromIndex - 1];
        }

        return prefixSumArray[toIndex];
    }

    public int PassingCars(int[] A) {
        int sum = 0;
        int carsToEast = 0; // 0 in array

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                sum += carsToEast;
            } else {
                carsToEast++;
            }

            if (sum > 1_000_000_000) {
                return -1;
            }
        }

        return sum;
    }

    public int CountDiv(int A, int B, int K) {
        int sum = 0;
        int firstMultiple = 0;

        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                firstMultiple = i;
                sum++;
                break;
            }
        }

        if (sum > 0 && firstMultiple < B) {
            return ((B - firstMultiple) / K) + 1;
        }

        return sum;
    }

    public int[] GenomicRangeQuery(String S, int[] P, int[] Q) {
        int[][] occurrences = new int[4][S.length()];

        int aAmount = 0;
        int cAmount = 0;
        int gAmount = 0;
        int tAmount = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'A') {
                aAmount++;
            } else if (S.charAt(i) == 'C') {
                cAmount++;
            } else if (S.charAt(i) == 'G') {
                gAmount++;
            } else if (S.charAt(i) == 'T') {
                tAmount++;
            }

            occurrences[0][i] = aAmount;
            occurrences[1][i] = cAmount;
            occurrences[2][i] = gAmount;
            occurrences[3][i] = tAmount;
        }

        int[] results = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            int startIndex = P[i];
            int endIndex = Q[i];


            if (occurrences[0][endIndex] > occurrences[0][startIndex] || S.charAt(startIndex) == 'A') {
                results[i] = 1;
                continue;
            }

            if (occurrences[1][endIndex] > occurrences[1][startIndex] || S.charAt(startIndex) == 'C') {
                results[i] = 2;
                continue;
            }

            if (occurrences[2][endIndex] > occurrences[2][startIndex] || S.charAt(startIndex) == 'G') {
                results[i] = 3;
                continue;
            }

            if (occurrences[3][endIndex] > occurrences[3][startIndex] || S.charAt(startIndex) == 'T') {
                results[i] = 4;
                continue;
            }

        }

        return results;
    }

    public int MinAvgTwoSlice(int[] A) {
        int startIndexOfMinAvg = 0;
        double minAvg = Integer.MAX_VALUE;

        if (A.length == 2) {
            return startIndexOfMinAvg;
        }

        for (int i = 0; i < A.length - 2; i++) {
            double avgSliceWith2 = (A[i] + A[i + 1]) / (double) 2;
            double avgSliceWith3 = (A[i] + A[i + 1] + A[i + 2]) / (double) 3;
            double minValue = Double.min(avgSliceWith2, avgSliceWith3);

            if (minValue < minAvg) {
                startIndexOfMinAvg = i;
                minAvg = minValue;
            }
        }

        // the average between the last two elements, was not evaluated in the previous loop, exp: [8,8,1,1] should return index: 2
        // here we evaluate that last possibility
        double lastTwoElementsAvg = (A[A.length - 1] + A[A.length - 2]) / (double) 2;
        if (lastTwoElementsAvg < minAvg) {
            startIndexOfMinAvg = A.length - 2;
        }

        return startIndexOfMinAvg;
    }


}
