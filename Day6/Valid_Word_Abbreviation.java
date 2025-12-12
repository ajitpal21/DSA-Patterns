// Neetcode-> Valid Word Abbreviation ? (solved in Neetcode)

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {

            char w_c = word.charAt(i);
            char a_c = abbr.charAt(j);

            
            if (Character.isDigit(a_c)) {   // If abbr char is digit

               
                if (a_c == '0') {    // when 0 is in starting then it is not allowed
                    return false;
                }

                int curr = 0;

           
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    curr = curr * 10 + (abbr.charAt(j) - '0');
                    j = j + 1;
                }
                i = i + curr;
            }
            else {
                // Characteris not equal
                if (w_c != a_c) {
                    return false;
                }

                i = i + 1;
                j = j + 1;
            }
        }

        // Both are traversed
        return i == word.length() && j == abbr.length();
    }
}
