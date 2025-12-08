// leetcode 151. Reverse Words in a String ?

class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        String words[] = s.split("\\s+"); //to convert entire string into 
                                           // words strings as an Array
                                           // and remove spaces bt the words
        int i = 0;
        int j = words.length - 1;

        while(i < j){           // reverse the words string
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;

            i++;
            j--;
        }
        return String.join(" ",words);  // combine all the words string with spaces
    }
}