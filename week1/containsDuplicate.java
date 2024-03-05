import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return false;
        if (length == 2)
            return nums[0] == nums[1];
        Arrays.sort(nums);
        int check = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] == check) {
                return true;
            }
            check = nums[i];
        }
        return false;
    }
}