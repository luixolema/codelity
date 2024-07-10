package codelity;

public class Lesson9 {
    public int MaxProfit(int[] A) {
        int maxProfit = 0;
        int previousValue = Integer.MAX_VALUE;
        for (int stockValue : A) {
            int profit = stockValue - previousValue;

            if (profit > maxProfit) {
                maxProfit = stockValue - previousValue;
            }

            if (stockValue < previousValue) {
                previousValue = stockValue;
            }

        }

        return maxProfit;
    }

    public int MaxSliceSum(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int sum = A[0];
        int maxSum = sum;

        for (int i = 1; i < A.length; i++) {
            int number = A[i];

            sum = Integer.max(sum + number, number);
            maxSum = Integer.max( maxSum, sum);
        }

        return maxSum;
    }
}
