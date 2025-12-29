// leetcode 680. Valid Palindrome II ?

/*Given a string s, return true if the s can be palindrome after deleting at most one character from it.*/

class Solution {
    public boolean validPalindrome(String s) {
          int i = 0;
          int j = s.length() - 1;

          while(i < j){
              if(s.charAt(i) != s.charAt(j)){
                  return palindromeHelper(s,i+1,j) || palindromeHelper(s,i,j-1);
              }
               i++; // if values at i and j is eqaul then move i and j
               j--;
          }
          return true;
    }

    public boolean palindromeHelper(String s, int i, int j){
          

          while(i < j){
              if(s.charAt(i) != s.charAt(j)){ 
                    return false;  // not palindrome
              }
              i++;
              j--;
          }
          return true;  // palindrome
    }
}