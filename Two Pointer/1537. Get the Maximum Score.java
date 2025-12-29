// leetcode 1537. Get the Maximum Score ?

class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
         int i = 0;
         int j = 0;

         long sum1 = 0;
         long sum2 = 0;
         long total_Score = 0;
         long MOD = 1000000007;

    while(i < nums1.length && j < nums2.length){
          
          if(nums1[i] < nums2[j]){
               sum1 = sum1 + nums1[i];
                 i++;
          }else if(nums1[i] > nums2[j]){
               sum2 = sum2 + nums2[j];
                 j++;
          }else{  // when we reach to the matching of nums1 and nums2 
              int value = nums1[i];

             total_Score = total_Score + Math.max(sum1,sum2) + value;
             sum1 = 0;  // again reset the sum1
             sum2 = 0;  // and sum2
            
             i++;
             j++;
          }
    }
         while(i < nums1.length){  // if nums1 is remaining
               sum1 = sum1 + nums1[i];
                i++;
         }
         while(j < nums2.length){   // if nums2 is remaining
               sum2 = sum2 + nums2[j];
                j++;
         }
     total_Score = total_Score + Math.max(sum1,sum2); // total Score 
     return (int) (total_Score % MOD); 
    }
}