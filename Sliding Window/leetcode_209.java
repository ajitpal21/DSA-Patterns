// leetcode 209. Minimum Size Subarray Sum ?

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE;
        int sum = 0;

        int i = 0;
        int j = 0;

        while(j < nums.length){
            sum = sum + nums[j];

            while(sum >= target){
                 size = Math.min(size, j - i + 1);
                 sum = sum - nums[i];
                 i++;
            }
            j++;
        }

        return size == Integer.MAX_VALUE ? 0 : size;
    }
}