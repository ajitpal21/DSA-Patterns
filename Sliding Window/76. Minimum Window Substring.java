// leetcode 76. Minimum Window Substring ?

// Brute force Approach which gives Time Limit Exceeded
class Solution {
    public String minWindow(String s, String t) {
      
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                int[] freq = new int[128];
                for (int x = i; x <= j; x++) {
                    freq[s.charAt(x)]++;
                }

                boolean valid = true;
                for (int x = 0; x < t.length(); x++) {
                    char c = t.charAt(x);
                    if (freq[c] == 0) {
                        valid = false;
                        break;
                    }
                    freq[c]--; 
                }

                if (valid) {
                    int len = j - i + 1;
                    if (len < minLen) {
                        minLen = len;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }
}

// Optimize Approach Using Sliding Window technique
class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        int[] freq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int required = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (freq[c] > 0) {
                required--;
            }
            freq[c]--;
            right++;

            while (required == 0) {

                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;
                if (freq[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
