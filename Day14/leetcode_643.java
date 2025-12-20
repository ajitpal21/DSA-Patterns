// leetcode 643. Maximum Average Subarray I ?

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double max = 0;
        double sum = 0;

        for(int i = 0; i < k; i++){
              sum = sum + nums[i];
        }
        max = sum;

        for(int i = k; i < nums.length; i++){
             
             sum = sum + nums[i]; //  windowa expand

             sum = sum - nums[i - k]; // windows contract from left

             max = Math.max(sum, max);
        }
        return max / k;
    }
}