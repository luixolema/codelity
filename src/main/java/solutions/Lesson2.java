package solutions;

import java.util.HashMap;
import java.util.Map;

public class Lesson2 {

    public int[] CyclicRotation(int[] A, int K){
        if (K == 0){
            return A;
        }

        if (K >= A.length){
            K = A.length % K;
        }

        int[] solutions = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int destinationIndex = i+K;
            if ( destinationIndex > A.length - 1){
                destinationIndex = destinationIndex - A.length;
            }
            solutions[destinationIndex] = A[i];
        }

        return solutions;
    }

    public int OddOccurrencesInArray(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : A) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        Map.Entry<Integer, Integer> ood = map.entrySet().stream().
                filter(entry -> entry.getValue() == 1)
                .findFirst()
                .get();

        return ood.getValue();
    }
}
