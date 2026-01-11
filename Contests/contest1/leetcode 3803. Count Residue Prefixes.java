// leetcode 3803. Count Residue Prefixes ?

class Solution {
    public int residuePrefixes(String s) {
         int count = 0;
         int distinct = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
                distinct++;
           }

            if(distinct == (i + 1) % 3){
                 count++;
            }
        }
        return count;
    }
}