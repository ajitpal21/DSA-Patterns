// leetcode 2461. Maximum Sum of Distinct Subarrays With Length K ?

// Brute force Approach  but it is a Time Limit Exceeded
   
   class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
         
         long max = 0;

         for(int i = 0; i <= nums.length - k; i++){
              
            Set<Integer> set = new HashSet<>();
              long sum = 0;
              boolean isDups = false;

              for(int j = i; j <= i + k - 1; j++){
                  if(set.contains(nums[j])){
                      isDups = true;
                      break;
                  }
                  set.add(nums[j]);
                  sum = sum + nums[j];
              }
              if(!isDups){
                 max = Math.max(max, sum);
               }
         }
         return max;
    }
}


// So here is the optimize solution Using Sliding Window Approach

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>(); // create a HashMap to track value
        int dups = 0; // create dups for tracking duplicates

        for(int i = 0; i < k; i++){
             if(!map.containsKey(nums[i])){
                  map.put(nums[i], 0);
             }
             map.put(nums[i], map.get(nums[i]) + 1);
            
             sum = sum + nums[i];

            if(map.get(nums[i]) > 1){
                 dups = dups + 1;
            }
        }
         
         if(dups == 0){  // if and only if duplicates is zero then update max
             max = Math.max(max, sum);
         }

         for(int i = k; i < nums.length; i++){
               
               if(!map.containsKey(nums[i])){
                   map.put(nums[i], 0);
               }
               map.put(nums[i], map.get(nums[i]) + 1);

                
                if(map.get(nums[i]) > 1){ // if  > 1 then update dups
                     dups = dups + 1;
                }

                sum = sum + nums[i];

                if(map.get(nums[i - k]) > 1){ 
                      dups = dups - 1;
                }

                map.put(nums[i - k], map.get(nums[i - k]) - 1);
                
                sum = sum - nums[i - k];

               if(dups == 0){
                  max = Math.max(max, sum);
               }
         }
      return max;
    }
}