// leetcode 457. Circular Array Loop ?

// Brute Force Approach 
class Solution {
    public int calcNextIdx(int nums[], int curr){ // finding the next Index 
         int next = curr;
         int seq = nums[curr];
         if(seq > 0){
            next = (next + seq) % nums.length;
         }else{
             int mod = seq % nums.length;
             int forward = nums.length + mod;
             next = (curr + forward) % nums.length;
         }
         return next;
    }

    public boolean circularArrayLoop(int[] nums) {
          for(int i = 0; i < nums.length - 1; i++){

            Set<Integer> set = new HashSet<>();
            set.add(i);

            boolean isPos = nums[i] > 0;

            int curr = i;

            while(true){
                 int next = calcNextIdx(nums, curr); // calculate next index 

                 if(isPos){  
                     if(nums[next] < 0){
                         break;
                     }else{
                          if(set.contains(next)){
                             if(curr != next){
                                return true;
                             }else{
                                break;
                             }
                          }
                          set.add(next);
                     }
                 }else{
                     if(nums[next] > 0){
                        break;
                     }else{
                          if(set.contains(next)){
                              if(curr != next){
                                  return true;
                              }else{
                                 break;
                              }
                          }
                          set.add(next);
                     }
                 }
                 curr = next;
            }
          }
          return false;
    }
}

// Better Approach with Time O(n) and space O(n)
class Solution {
    public int calcNextIdx(int nums[], int curr){ // finding the next Index 
         int next = curr;
         int seq = nums[curr];
         if(seq > 0){
            next = (next + seq) % nums.length;
         }else{
             int mod = seq % nums.length;
             int forward = nums.length + mod;
             next = (curr + forward) % nums.length;
         }
         return next;
    }

    public boolean circularArrayLoop(int[] nums) {
          for(int i = 0; i < nums.length - 1; i++){

            Set<Integer> set = new HashSet<>();
            set.add(i);

            boolean isPos = nums[i] > 0;

            int curr = i;

            while(true){
                 int next = calcNextIdx(nums, curr); // calculate next index 

                 if(isPos){  
                     if(nums[next] < 0){
                         break;
                     }else{
                          if(set.contains(next)){
                             if(curr != next){
                                return true;
                             }else{
                                break;
                             }
                          }
                          set.add(next);
                     }
                 }else{
                     if(nums[next] > 0){
                        break;
                     }else{
                          if(set.contains(next)){
                              if(curr != next){
                                  return true;
                              }else{
                                 break;
                              }
                          }
                          set.add(next);
                     }
                 }
                 curr = next;
            }
             curr = i;

             if(isPos){  // here we will not checking all the indexes here we will chech if any negative value exit so iterate from there 
                  while(nums[curr] > 0){
                    int next = calcNextIdx(nums, curr);
                         nums[curr] = 0;
                         curr = next;
                    }
                }else{
                     while(nums[curr] < 0){
                         int next = calcNextIdx(nums, curr);
                         nums[curr] = 0;
                         curr = next;
                }
             }
          }
          return false;
    }
}

// Another Approach using slow and fast Pointer with Time O(n) ans Space O(1)

class Solution {
    public int calcNextIdx(int nums[], int curr){ // finding the next Index 
         int next = curr;
         int seq = nums[curr];
         if(seq > 0){
            next = (next + seq) % nums.length;
         }else{
             int mod = seq % nums.length;
             int forward = nums.length + mod;
             next = (curr + forward) % nums.length;
         }
         return next;
    }

    public boolean circularArrayLoop(int[] nums) {
          for(int i = 0; i < nums.length - 1; i++){
              if(nums[i] == 0){
                 continue;
              }

              boolean isPos = nums[i] > 0;

              int slow = i;
              int fast = i;

              do{
                slow = calcNextIdx(nums, slow);

                fast = calcNextIdx(nums, fast);

                if(isPos){
                      if(nums[fast] < 0){
                         break;
                      }
                }else{
                    if(nums[fast] > 0){
                         break;
                    }
                }
                fast = calcNextIdx(nums, fast);

                if(isPos){
                      if(nums[fast] < 0){
                         break;
                      }
                }else{
                     if( nums[fast] > 0){
                         break;
                     }
                }

                if(slow == fast){   // if cycle is detected
                     if(slow != calcNextIdx(nums, slow)){
                        return true;
                     }
                     break;
                }
              }while(slow != fast);

              int curr = i;

              if(isPos){
                  while(nums[curr] > 0){
                     int next = calcNextIdx(nums, curr);
                     nums[curr] = 0;
                     curr = next;
                  }
              }else{
                 while(nums[curr] < 0){
                     int next = calcNextIdx(nums, curr);
                     nums[curr] = 0;
                     curr = next;
                 }
              }
          }
     return false;        
    }
}