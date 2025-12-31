// leetcode 2302. Count Subarrays With Score Less Than K ?

// Brute force Approach which gives time limit exceeded
class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;

        for(int i = 0; i < nums.length; i++){
              long sum = 0;
              long score = 0;
              for(int j = i; j < nums.length; j++){
                  sum = sum  + nums[j];
                  score = sum * (j - i + 1);

                  if(score < k){
                     count = count + 1;
                    }
                }
        }
        return count;
    }
}

// Optimize Approach using Sliding Window technique
class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        int i = 0;
        int j = 0;
        long sum = 0;

        while(j < nums.length){
             sum = sum + nums[j];
             
            while(sum * (j - i + 1) >= k){
                sum = sum - nums[i];
                   i++;
             }
          count = count + (j - i + 1);
          j++;
        }
        return count;
    }
}
