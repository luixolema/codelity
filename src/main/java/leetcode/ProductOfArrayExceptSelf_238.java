package leetcode;

/**
 *
 */
public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] rightToLeftMultiplicationAccumulation = new int[nums.length];
        rightToLeftMultiplicationAccumulation[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            rightToLeftMultiplicationAccumulation[i] = rightToLeftMultiplicationAccumulation[i+1] * nums[i];
        }

        int leftToRightAccumulation = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            result[i] = leftToRightAccumulation * rightToLeftMultiplicationAccumulation[i+1];
            leftToRightAccumulation *= nums[i];

        }

        result[nums.length - 1] = leftToRightAccumulation;



        return result;
    }
}
