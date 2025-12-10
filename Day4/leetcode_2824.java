// leetcode 2824. Count Pairs Whose Sum is Less than Target ?

/* Given a 0-indexed integer array nums of length n and an integer target,
 return the number of pairs (i, j) where 0 <= i < j < n and nums[i] + nums[j] < target. */

 class Solution {
    public int countPairs(List<Integer> nums, int target) {
          Collections.sort(nums);

          int i = 0;
          int j = nums.size() - 1;

          int count = 0;

          while(i < j){
             int sum = nums.get(i) + nums.get(j);  // sum of element of list of 
                                                   // index i and j;
             if(sum < target){
                   count = count + (j - i); // (j-i) -> total no of pair with i index;
                   i++;
             }else{
                 j--;
             }
          }
          return count;
    }
}