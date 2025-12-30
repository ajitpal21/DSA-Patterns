// leetcode 992. Subarrays with K Different Integers ?

// Brute force Approach which gives Time Limit Exceeded
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

//Optimize Approach Using Sliding Window technique
class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
          return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int count = 0;
        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(j < nums.length){
            if(!map.containsKey(nums[j])){
                 map.put(nums[j], 0);
            }
            map.put(nums[j], map.get(nums[j]) + 1);

            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            count = count + j - i + 1;
            j++;
        }
        return count;
    }
}
