package leetcode;


/***
 * The idea is to apply kadane's algorithm not only to find the maximum subarray but also the minimum (in case this actually affects the total sum (there are negative values)).
 *
 * Why to find the minimum?:
 *  If we have positive and negative values in the array, then if those negative values didnt exist we would have a higher total sum, right?
 *  what if we could extract/skip those negative sum subarrays?
 *      then we could end up with a higher sum. and because we have a circular array then that actually is a possible scenario.
 *      example: [1, 1, (-1, -1, -1), 1, 1] if we extract the negative values we would end up with [1 , 1,() 1, 1] that actually is a valid subarray if we iterate from index 5 to 3 (circular).
 *
 *  Conclusion: If we have the minimum subarray sum, and that sum is lower than 0 (ex: -3)
 *  then we can conclude:
 *   - that value was subtracted form the total sum
 *   - that value could be added back to the total to get a higher total sum. in the example: 1 + 3 = 4
 *      the 1 represent the total sum of the array provided in the example [1, 1, (-1, -1, -1), 1, 1]
 *      the 3 represent the subtracted value from the total sum: (negative minSum: -3)
 *      the 4 is the new higher total sum without the subtracted value
 *  Therefor we can calculate a higher total sum: totalSum + subtractedValue = 1 + 3 = 4, and get a higher maximum sum (a possible better solution!).
 *
 *  Its just a POSSIBLE solution because there could be a better smaller sub array in the whole array that could give a higher total sum:
 *      example: [1, (-1, -1, -1), 3, (-1, -1, -1), 1]
 *      total sum = -1
 *      minSum = -3
 *      totalSum + minSumValue = -1 + 3 = 2
 *      possible better solution is 2 but actually the best solution is 3, because the subarray [3] is the maximum sum.
 *      this solution (3) is founded by the maxSum of the kadane's algorithm. so be careful with this and also compare the possible solution with the maxSum of the kadane's algorithm.
 *
 *  An edge case:
 *  - If all the values are negative the maximum sum will also be negative, and it will be the maximum number in the array (the lest negative number).
 *  - this solution is founded by the maxSum of the kadane's algorithm. but can not be combined with the possible solution of the totalSum + subtractedSumValue because the totalSum is also negative.
 *  - so consider this edge case first and return the maxSum of the kadane's algorithm if it is negative.
 *
 *  so at the end the solution is to compare the maxSum of the kadane's algorithm with the totalSum + subtractedSumValue
 */
public class Maximum_Sum_Circular_Subarray_918 {
    public int maxSubarraySumCircular(int[] nums) {
        var maxSum = nums[0];
        var currentSum = nums[0];
        var total = nums[0];
        var minSum = nums[0];
        var currentMinSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            currentMinSum = Math.min(nums[i], currentMinSum + nums[i]);
            minSum = Math.min(minSum, currentMinSum);
            maxSum = Math.max(maxSum, currentSum);
            total+=nums[i];
        }

        if (maxSum < 0) {
            return maxSum;
        }

        if (minSum < 0) { // only in the case some values were subtracted from the total sum (actually not needed but just to fallow the explanation
            return Math.max(maxSum, total + (minSum * -1));
            // this could be shorted likeÖ total - minsum (because minSum is already negative so we are actually adding that to the total) but just to fallow the explanation I leave it like that.
        }
        //actually the whole condition is not necessary, but I think it helps to fallow better the explanation.

        return maxSum;
    }

}
