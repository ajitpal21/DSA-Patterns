// leetcode 239. Sliding Window Maximum ?

// Brute force Approach which gives Time Limit Exceeded
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         int n = nums.length;
       
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= n-k; i++){
            int maxi = nums[i];

            for(int j = i; j <= i+k-1;j++){
                maxi = Math.max(maxi,nums[j]);
            }
            list.add(maxi);
        }
        int result[] = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
             result[i] = list.get(i);
        }
        return result;
  }
}