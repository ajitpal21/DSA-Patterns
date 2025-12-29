// leetcode 31. Next Permutation ?

class Solution {
    public void nextPermutation(int[] nums) {
         int index = -1;

         for(int i = nums.length - 1; i > 0; i--){ // this is for from which index we should do changes
                if(nums[i] > nums[i-1]){
                     index = i - 1;
                     break;
                }
         }

     if(index != -1){
        //  int swap_index = -1;
         for(int j = nums.length - 1; j >= index + 1; j--){ // this is for that which index is swaped
                if(nums[index] < nums[j]){
                        // swap_index = j;
                        swap(nums, index, j);
                        break;
                }
            }
        //   swap(nums, index, swap_index);
        }   
          reverse(nums, index + 1, nums.length - 1);

    }
    
    public void swap(int nums[], int i, int j){ // swap function
           int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }

    public void reverse(int nums[], int i, int j){  // reverse function
            while(i < j){
              int temp = nums[i];
              nums[i] = nums[j];
              nums[j] = temp;
              i++;
              j--;
           }
    }
}