// leetcode 187. Repeated DNA Sequences ?

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
       
        for(int i = 0; i < s.length() - 9; i++){ // we take a loop which stops before 9th index
           
            String str = s.substring(i, i+10);    // take substring into the str String
             
              if(map.containsKey(str)){   // if map contains the str
                   if(!list.contains(str)) list.add(str);  // if list does not contains the str then add into the list
              }

              map.put(str, map.getOrDefault(str, 0) + 1);  // put into the map
        }
        return list;
    }
}
