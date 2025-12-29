// leetcode 344. Reverse String ? 

/* Write a function that reverses a string. The input string is given as an array of characters s. 
    Example 1:
        Input: s = ["h","e","l","l","o"]
        Output: ["o","l","l","e","h"]
*/

class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while(i < j){          // the approach is simple is that swap 
            char temp = s[i];  // the values of i and j until i cross j
             s[i] = s[j];
             s[j] = temp;
             i++;
             j--;
        }
    }
}