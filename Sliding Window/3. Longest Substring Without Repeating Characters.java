// leetcode 3. Longest Substring Without Repeating Characters ?

class Solution {
    public int lengthOfLongestSubstring(String s) {
         
         int max = 0;

         for(int i = 0; i < s.length(); i++){
              Set<Character> set = new HashSet<>();

              for(int j = i; j < s.length(); j++){
                   if(set.contains(s.charAt(j))){
                         break;
                   }

                   set.add(s.charAt(j));
                   max = Math.max(max, j - i + 1);
              }
         }
         return max;
    }
}


// And here is the another Approach to solve (Sliding window pattern)
class Solution {
    public int lengthOfLongestSubstring(String s) {

       Set<Character> set = new HashSet<>(); 
       int i = 0;
       int j = 0;
       int max = 0;

       while(j < s.length()){
           
           while(set.contains(s.charAt(j))){
                 set.remove(s.charAt(i));
                 i++;
           }

           set.add(s.charAt(j));
           max = Math.max(max, j - i + 1);
           j++;
       }
       return max;
    }
}