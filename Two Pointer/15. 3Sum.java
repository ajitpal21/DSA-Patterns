// leetcode 15. 3Sum ?

class Solution {

    public void twoSumHelper(int f, int nums[], List<List<Integer>> list){
         
         int i = f+1;
         int j = nums.length-1;

         while(i < j){
              int sum = nums[f] + nums[i] + nums[j]; //target = 0;

               if(sum > 0){
                   j--;
               }else if(sum < 0){
                   i++;
               }else{
                   list.add(Arrays.asList(nums[f], nums[i], nums[j]));
                     i++;
                     j--;
                     
                     while(i < j && nums[i] == nums[i-1]){
                           i++;     // to remove duplicate
                     }
                     while(i < j && nums[j] == nums[j+1]){
                         j--;       // to remove duplicate
                     }
               }
         }
    }
    public List<List<Integer>> threeSum(int[] nums) {
          ArrayList<List<Integer>> list = new ArrayList<>();   
          Arrays.sort(nums);
         
           for(int f = 0; f < nums.length; f++){  //f -> first pointer(starting) pointer
                if(nums[f] > 0){  
                    break;     // because here target already greater then 0 (nums[f] > 0)
                }
                
                 if(f == 0 || nums[f] != nums[f-1]){
                   twoSumHelper(f,nums,list);
                 }
           }
          return list;
    }
}