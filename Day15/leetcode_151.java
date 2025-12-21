// leetcode 151. Reverse Words in a String ?

class Solution {
    public String reverseWords(String s) {
         s = s.trim();
         String[] words  = s.split("\\s+");

         int i = 0;
         int j = words.length - 1;

         while(i < j){
              String temp = words[i];
              words[i] = words[j];
              words[j] = temp;
              i++;
              j--;
         }
         return String.join(" ", words); // join the words with space 
    }
}

// And here is Another Approach for this problem

class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        String[] words = s.split("\\s+");

        StringBuilder sb = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--){
               
               sb.append(words[i]);

               if(i != 0){
                 sb.append(" ");
               }
        }
        return sb.toString();
    }
}