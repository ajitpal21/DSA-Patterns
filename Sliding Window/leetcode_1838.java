// leetcode 1838. Frequency of the Most Frequent Element ?

// Brute force Approach
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max = 0;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
              int sum = 0;

              for(int j = i; j < nums.length; j++){
                  sum = sum + nums[j];

                  if(nums[j] * (j - i + 1) - sum > k){
                      break;
                  }
              max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}

// Optimize solution using Sliding window (variable)

class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max = 0;
        Arrays.sort(nums);

        long sum = 0;
        int i = 0;
        int j = 0;

        while(j < nums.length){
             sum = sum + nums[j];

             while((long)nums[j] * (j - i + 1) - sum > k){
                   sum = sum - nums[i];
                   i++;
             }
             max = Math.max(max, j - i + 1);
             j++;
        }
        return max;
    }
}