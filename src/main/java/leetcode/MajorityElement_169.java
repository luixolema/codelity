package leetcode;

public class MajorityElement_169 {
    /**
     * The funny thing in here is to realize that if we keep counting the most common element is the array we will always end up with the majority element
     * the other solution is just to use a hashmap to count the elements and return the one that has the majority
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int mostCommonElement = nums[0];

        for (int num : nums) {
            if (mostCommonElement == num) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                mostCommonElement = num;
                count = 1;
            }
        }

        return mostCommonElement;
    }

}
