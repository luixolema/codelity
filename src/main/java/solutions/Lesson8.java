package solutions;

import java.util.HashMap;

public class Lesson8 {
    public int Dominator(int[] A){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <A.length; i++) {
            int number = A[i];
            Integer previousOccurrences = map.getOrDefault(number, 0);
            map.put(number, previousOccurrences + 1);
            if (map.get(number) > A.length/2){
                return i;
            }
        }

        return -1;
    }

    public int EquiLeader(int[] A){
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        int leader = -1;

        for (int i = 0; i <A.length; i++) {
            int number = A[i];
            Integer previousOccurrences = occurrences.getOrDefault(number, 0);
            occurrences.put(number, previousOccurrences + 1);
            if (occurrences.get(number) > A.length/2){
                leader = A[i];
            }
        }

        int equiLeaderAmount = 0;

        int leaderAmountInArray = occurrences.get(leader);
        int leaderAmountInFirstSubArray = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == leader){
                leaderAmountInFirstSubArray++;
            }

            int leadersInSecondSubArray = leaderAmountInArray - leaderAmountInFirstSubArray;
            int fistSubArrayLength = i + 1;
            int secondSubArrayLength = A.length - fistSubArrayLength;

            if (secondSubArrayLength / (double) 2 >= leadersInSecondSubArray){
                // the leader in the second subArray is not the same anymore
                break;
            }

            if (fistSubArrayLength / (double)2 < leaderAmountInFirstSubArray){
                equiLeaderAmount++;
            }
        }

        return equiLeaderAmount;
    }
}
