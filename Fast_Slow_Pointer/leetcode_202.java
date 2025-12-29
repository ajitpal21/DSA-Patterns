// leetcode 202. Happy Number ?

class Solution {
    public int sumOfSquares(int n){ // Here we find the Sum of Squares of Numbers
          int sum = 0;
        while(n > 0){
          int digit = n % 10;
          sum = sum + digit * digit;
          n = n / 10;
        }
          return sum;
    }
    
    public boolean isHappy(int n) {
       HashSet<Integer> set = new HashSet<>();

         while(n != 1){
               if(set.contains(n)){
                   return false;   // if number is repeated and cycle detected
               }
             set.add(n);
             n = sumOfSquares(n);
         }
        return true;  // if my number is reached to the 1
    }
}

// And here  is the second Approach by slow and fast pointer

class Solution {
    public int sumOfSquares(int n){  // here is the function to find sum of Squares of no
         int sum = 0;
         while(n > 0){
         int digit = n % 10;
         sum = sum + digit * digit;
         n = n / 10;
         }
         return sum;  // return the sum
    }
    public boolean isHappy(int n) {
         int slow = n;
         int fast = n;

         while(true){
              slow = sumOfSquares(slow);  // it moves 1 step 
              fast = sumOfSquares(sumOfSquares(fast)); /// it moves 2 step

              if(fast == 1) return true; // find 1 so it becomes Happy no

              if(slow == fast) return false; // detect cycle so not Happy no
         }
    }
}