//GFG. - Next higher palindromic number using the same set of digits ?


class Solution {
    public String nextPalin(String N) {
        // complete the function here
        int len = N.length();
        
        if(len <= 2) return "-1";
        
        int halfLen = len/2;
        
        char[] left = N.substring(0, halfLen).toCharArray();
        
        if(!nextPermutation(left)) return "-1";
        
        StringBuilder ans = new StringBuilder();
        
        ans.append(left);
        
        if(len % 2 == 1){
            ans.append(N.charAt(halfLen));
        }
        ans.append(new StringBuilder(new String(left)).reverse());
        
        return ans.toString();
        
    }
    
    public boolean nextPermutation(char arr[]){
          int index = -1;
          
          for(int i = arr.length - 1; i > 0; i--){
               if(arr[i] > arr[i-1]){
                   index = i-1;
                   break;
               }
          }
          if(index == -1) return false;
               
               for(int j = arr.length - 1; j >= index + 1; j--){
                     if(arr[index] < arr[j]){
                           swap(arr, index, j);
                           break;
                     }
               }
          reverse(arr, index +  1, arr.length - 1);
          return true;
    }
    
    public void swap(char arr[], int i, int j){
           char temp = arr[i];
           arr[i] = arr[j];
           arr[j] = temp;
    }
    
    public void reverse(char arr[], int i, int j){
         while(i < j){
              char temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
              i++;
              j--;
         }
    }
}

