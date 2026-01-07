// GFG - Meeting Rooms ?

// Brute force Approach
class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
        
         for(int i = 0; i < arr.length; i++){
              int s1 = arr[i][0];
              int e1 = arr[i][1] - 1;
              
              for(int j = i + 1; j < arr.length; j++){
                    int s2 = arr[j][0];
                    int e2 = arr[j][1] - 1;
                    
                    if(e1 >= s2 && e2 >= s1){
                          return false;
                    }
              }
         }
         
         return false;
    }
}

// Optimized Approach
class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
        
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        for(int i = 1; i < arr.length; i++){
              int s2 = arr[i][0];
              int e1 = arr[i - 1][1] - 1;
              
              if(s2 <= e1){
                  return false;
              }
        }
        
        return true;
    }
}