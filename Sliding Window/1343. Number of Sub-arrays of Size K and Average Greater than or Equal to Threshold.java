// leetcode 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold ?

// Brute force Approach 

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;

        for(int i = 0; i < arr.length - k + 1; i++){
               int sum = 0;

               for(int j = i; j < i + k; j++){
                   sum = sum + arr[j];
               }
              int Average = sum / k;

               if(Average >= threshold){
                    count = count + 1;
               }
        }
        return count;
    }
}

// Optimize Approach using Sliding Window technique

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
         int count = 0;
         int sum = 0;
         int Average = 0;

         for(int i = 0; i < k; i++){
             sum = sum + arr[i];
         }
           Average = sum / k;
         if(Average >= threshold){
              count = count + 1;
         }

         for(int i = k; i < arr.length; i++){
              sum = sum + arr[i];
              sum = sum - arr[i - k];
            
            Average = sum / k;

            if(Average >= threshold){
                  count = count + 1;
            }

         }
         return count;
    }
}