// leetcode 3804. Number of Centered Subarrays ?

class Solution {
    public int centeredSubarrays(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length; i++){
              int sum = 0;
              Set<Integer> set = new HashSet<>();

              for(int j = i; j < nums.length; j++){
                   sum = sum + nums[j];
                   set.add(nums[j]);

                   if(set.contains(sum)){
                      count++;
                   }
              }
        }

        return count;
    }
}