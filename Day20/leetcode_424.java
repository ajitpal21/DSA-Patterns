// leetcode 424. Longest Repeating Character Replacement ?

// Brute force Approach which gives a Time limit Exceeded

class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;

        for(int i = 0; i < s.length(); i++){
              int maxC = 0;
              int counts[] = new int[26];
  
              for(int j = i; j < s.length(); j++){
                  
                char c = s.charAt(j);
                counts[c - 'A'] = counts[c - 'A'] + 1;
                maxC = Math.max(maxC, counts[c - 'A']);

                 int ops = (j - i + 1) - maxC; 

                 if(ops > k){
                     break;
                 }

                max = Math.max(max, j - i + 1);
              }
        }
        return max;
    }
}