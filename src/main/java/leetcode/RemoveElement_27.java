package leetcode;

public class RemoveElement_27 {

    /**
     * Iterate from the beginning of the array and if the element matches the value, substitute it for the last element of the array that is different.
     * keep an endPointer at the end of the array to keep track of the last switched values, when the endPointer is equal to the first pointer, we can return the first pointer.
     */
    public int removeElement(int[] nums, int val) {
        int pointer1 = 0;
        int endPointer = nums.length - 1;

        if (endPointer == 0 && nums[0] == val) {
            return 0;
        }

        while (pointer1 <= endPointer) {
            if (nums[pointer1] == val) {
                while (nums[endPointer] == val && endPointer > pointer1) {
                    endPointer--;
                }
                if (pointer1 == endPointer) {
                    return pointer1;
                }
                nums[pointer1] = nums[endPointer];
                endPointer--;
                pointer1++;
            } else {
                pointer1++;
            }
        }

        return pointer1;
    }
}


























































