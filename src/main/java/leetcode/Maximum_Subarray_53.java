package leetcode;

public class Maximum_Subarray_53 {
    public int maxSubArray(int[] nums) {
        var maxSum = Integer.MIN_VALUE;
        var currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;

    }
}
