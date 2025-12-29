// leetcode 287. Find the Duplicate Number ?

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {  // beacause we check for slow = 0 and fast = 0 so we take do while here
             slow = nums[slow];
             fast = nums[nums[fast]];

             if(slow == fast){
                 break;
             }
        } while(slow != fast);

        int n1 = 0;
        int n2 = slow;

        while(n1 != n2){
             n1 = nums[n1];
             n2 = nums[n2];
        }
        return n1;
    }
}

// And here is the Second and Simple Approach

class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
              if(set.contains(nums[i])){
                 return nums[i];
              }
              set.add(nums[i]);
        }
        return -1;
    }
}