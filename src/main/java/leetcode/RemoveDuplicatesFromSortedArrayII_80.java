package leetcode;


/**
 * Having 2 pointer, one initially at position 2 the second at 3
 * if the value at the second pointer is different form the value at the first pointer and at the firstPointer -1 the set that value at the first pointer + 1
 * the idea its to find different values at the first pointer and the first pointer - 1, incrementing pointer 2 till the end of the array
 * at the end, pointer 1 will be the length of the array without duplicates
 */
public class RemoveDuplicatesFromSortedArrayII_80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        var pointer1 = 1;
        var pointer2 = 2;
        while (pointer2 < nums.length) {
            if (nums[pointer2] != nums[pointer1]  || nums[pointer2] != nums[pointer1 - 1]) {
                nums[++pointer1] = nums[pointer2];
            }

            pointer2++;
        }

       return pointer1 +1;
    }

}
