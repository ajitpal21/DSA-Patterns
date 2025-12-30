// leetcode 992. Subarrays with K Different Integers ?

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int max = 0;

        for(int i = 0; i < nums.length; i++){
            HashMap<Integer, Integer> map = new HashMap<>();

              for(int j = i; j < nums.length; j++){
                 if(!map.containsKey(nums[j])){
                       map.put(nums[j], 0);
                 }
                map.put(nums[j], map.get(nums[j]) + 1);

                    if(map.size() == k){
                         max = max + 1;
                    }else if(map.size() > k){
                          break;
                    }
                }
        }
        return max;
    }
}
