package leetcode;


/**
 * 2 pointer if both have the same value, then start looking for a new different value for the 2 pointer
 * then reset the first pointer to the new value and then repeat the process, it ends when the second pointer reach the end of the array
 * at the end the first pointer is located at the last different value so you can count them by adding 1 to the first pointer
 */
public class RemoveDuplicatesFromSortedArray_27 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int pointer1 = 0;
        int pointer2 = 1;

        while (pointer2 < nums.length){
           if (nums[pointer1] == nums[pointer2]) {
               while (pointer2 < nums.length && nums[pointer1] == nums[pointer2]) {
                   pointer2++;
               }
               if (pointer2 >= nums.length) {
                   break;
               }
               nums[++pointer1] = nums[pointer2];
           }else{
               pointer1++;
           }
        }

        return pointer1+1;
    }
}
