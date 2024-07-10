package leetcode;

/**
 * For each position you can get as many more positions forward more as the value of the current position or the best accumulated value so far
 * so keep track of the best accumulated value so far, rest 1 on each new reach position and compare with the value in the current position to set a new masReachedPositionFromCurrent
 * if the maxReachedPositionFromCurrent is 0 and we are not at the end of the array, return false
 */
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int maxReachedPositionFromCurrentPosition = nums[0];

        for (int i = 0; i < nums.length; i++) {

            if (i == nums.length - 1){
                return true;
            }

            maxReachedPositionFromCurrentPosition = Math.max(maxReachedPositionFromCurrentPosition - 1, nums[i]);

            if (maxReachedPositionFromCurrentPosition == 0 && i < nums.length - 1) {
                return false;
            }
        }

        return true;
    }
}
