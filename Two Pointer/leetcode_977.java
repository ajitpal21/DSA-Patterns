// leetcode 977. Squares of a Sorted Array ?

class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;


        while(i < j){
             nums[i] = nums[i] * nums[i];

             nums[j] = nums[j] * nums[j];

             i++;
             j--;
        }

        if(nums.length % 2 != 0) {
            nums[nums.length / 2] = nums[nums.length / 2] * nums[nums.length / 2];
        }
        
        Arrays.sort(nums);
      return nums;
    }
}