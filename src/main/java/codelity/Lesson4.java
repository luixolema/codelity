package codelity;

import java.util.Arrays;
import java.util.HashMap;

public class Lesson4 {

    public int FrogRiverOne(int[] A, int X) {
        HashMap<Integer, Integer> positionToTimeMap = new HashMap<>();

        for (int time = 0; time < A.length; time++) {
            if (positionToTimeMap.size() == X) {
                break;
            }

            int position = A[time];
            if (position <= X) {
                Integer earliestTime = positionToTimeMap.get(position);
                if (earliestTime != null) {
                    if (time < earliestTime) {
                        positionToTimeMap.put(position, time);
                    }
                } else {
                    positionToTimeMap.put(position, time);
                }
            }
        }

        if (positionToTimeMap.size() < X) {
            return -1;
        }

        final int[] maxTime = {Integer.MIN_VALUE};

        positionToTimeMap.forEach((position, time) -> {
            if (time > maxTime[0]) {
                maxTime[0] = time;
            }
        });

        return maxTime[0];
    }

    public int PermCheck(int[] A) {
        int[] occurrences = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            int number = A[i];
            if (number > A.length) {
                return 0;
            }
            occurrences[number] = occurrences[number] + 1;
        }

        for (int i = 1; i < occurrences.length; i++) {
            if (occurrences[i] != 1) {
                return 0;
            }
        }

        return 1;
    }

    public int[] MaxCounters(int N, int[] A) {
        int maxValue = 0;
        int minValue = 0;
        int[] counters = new int[N];

        for (int i = 0; i < A.length; i++) {
            int operation = A[i];
            if (operation == N + 1) {
                minValue = maxValue;
            } else {
                if (counters[operation-1] < minValue) {
                    counters[operation-1] = minValue + 1;
                } else {
                    counters[operation-1]++;
                }

                int counterValue = counters[operation-1];
                if (maxValue < counterValue) {
                    maxValue = counterValue;
                }
            }
        }

        if (minValue > 0)
            for (int i = 0; i < counters.length; i++) {
                if (counters[i] < minValue) {
                    counters[i] = minValue;
                }
            }

        return counters;
    }


    public int MissingInteger(int[] A){
        Arrays.sort(A);
        int missingInteger = 1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == missingInteger){
                missingInteger++;
            }else{
                break;
            }
        }

        return missingInteger;
    }
}
