package leetcode;

/**

 */
public class JumpGameII_45 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int jumps = 1;
        int maxReachedPosition = nums[0];
        int reachableAreaLeftLimit = 1;
        int reachableAreaRightLimit = nums[0];

        while (maxReachedPosition < nums.length - 1){
            jumps++;
            for (int i = reachableAreaLeftLimit; i <= reachableAreaRightLimit; i++){
                maxReachedPosition = Math.max(maxReachedPosition, i + nums[i]);
            }
            reachableAreaLeftLimit = reachableAreaRightLimit + 1;
            reachableAreaRightLimit = maxReachedPosition;
        }

        return jumps;
    }
}
