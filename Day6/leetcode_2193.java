// leetcode 2193. Minimum Number of Moves to Make Palindrome ?

class Solution {

     public int minMovesToMakePalindrome(String s) {
       
       // char[] arr = s.toCharArray();
        // check the matching from Right side
        int a = minMovesToMakePalindromeleft(s.toCharArray());

        // check the matching from the left side
        int b = minMovesToMakePalindromeRight(s.toCharArray());

        // take the minimum 
        return Math.min(a, b);
    }

    public void swap(char arr[], int i, int j){
          char temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
    }

    // checking from left
    public int minMovesToMakePalindromeleft(char[] s) {
        char[] arr = s;
        
        int left = 0;
        int right = arr.length - 1;
        int moves = 0;

        while(left < right){
            if(arr[left] == arr[right]){
                 left++;
                 right--;
                 continue;
            }

        int k = right;
        while(k > left && arr[k] != arr[left]){
                k--;
        }
        
        if(k == left){
             swap(arr, left, left + 1);
             moves++;
        }else{
             while(k < right){
             swap(arr, k, k + 1);
             moves++;
             k++;
            }
            left++;
            right--;
        }
    }

        return moves;
    }

    // checking from Right 
    public int minMovesToMakePalindromeRight(char[] s) {
        char[] arr = s;
        
        int left = 0;
        int right = arr.length - 1;
        int moves = 0;

        while(left < right){
            if(arr[left] == arr[right]){
                 left++;
                 right--;
                 continue;
            }

        int k = left;
        while(k < right && arr[k] != arr[right]){
                k++;
        }
        
        if(k == right){
             swap(arr, right, right - 1);
             moves++;
        }else{
             while(k > left){
             swap(arr, k, k - 1);
             moves++;
             k--;
            }
            left++;
            right--;
        }
    }

        return moves;
    }
}