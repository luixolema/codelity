package leetcode;


/***
 * first realize that if k > nums.length, then we can just use k = k % nums.length and then rotate the array
 * second: after that if we could just push the element from the index 0 to k-1 index of array then we actually could visualize
 *      that end elements are pushed out of the array (that will be the fist part ofter rotating the array)
 * so we can divide the array in 2 parts, the fist one will be actually the second half of the rotated array and the second one the first half of the rotated array
 * to make it easier to do, I just create a new array insert the elements in the correct order and then populate the original array with the new one.
 */

public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        int elementsPushedOutOfTheArray = k > nums.length ? k % nums.length  : k;
        int secondHalfInclusiveLimitIndex = nums.length - 1 - elementsPushedOutOfTheArray;

        int[] result = new int[nums.length];
        for (int i = 0; i <= secondHalfInclusiveLimitIndex; i++) {
            result[i+elementsPushedOutOfTheArray] = nums[i];
        }

        for (int i = 0; i < elementsPushedOutOfTheArray; i++) {
            result[i]  = nums[secondHalfInclusiveLimitIndex + i + 1];
        }

        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }
}
