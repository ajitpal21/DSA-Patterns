// leetcode 1. Two Sum ?

/* Given an array of integers nums and an integer target, 
return indices of the two numbers such that they add up to target. */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

         for(int i = 0; i < nums.length; i++){
              int lookingFor = target - nums[i];

              if(map.containsKey(lookingFor)){
                   return new int[] {i,map.get(lookingFor)};
              }
              map.put(nums[i],i);
         }
         return new int[] {-1,-1};
    }
}