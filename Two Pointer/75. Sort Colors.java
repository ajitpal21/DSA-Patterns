// leetcode 75. Sort Colors ?

class Solution {
    public void sortColors(int[] nums) {
         
         int i = 0;
         int j = nums.length - 1;
         int k = 0;

         while(k <= j){
             if(nums[k] == 1){  // if nums[k] == 1 then move k (k++)
                k++;
             }else if(nums[k] == 2){
                  int temp = nums[j];
                  nums[j] = nums[k];
                  nums[k] = temp;
                  j--;
             }else{
                 int temp = nums[i];
                 nums[i] = nums[k];
                 nums[k] = temp;
                 i++;
                 k++;
             }
         }
    }
}
