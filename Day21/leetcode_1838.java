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