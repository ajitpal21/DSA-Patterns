// leetcode 904. Fruit Into Baskets ?

// Brute force Approach which gives Time limit Exceeded
class Solution {
    public int totalFruit(int[] fruits) {
       int max= 0;

       for(int i = 0; i < fruits.length; i++){
           
          HashMap<Integer, Integer> map = new HashMap<>();
         
           for(int j = i; j < fruits.length; j++){
                 
                 if(!map.containsKey(fruits[j])){
                     map.put(fruits[j], 0);
                 }
                 map.put(fruits[j], map.get(fruits[j]) + 1);  

                 if(map.size() > 2){
                  break;
            }
            max = Math.max(max, j - i + 1);
        }
    }
       return max;
    }
}

// Optimize Approach Using Sliding Window technique
class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int j = 0;
        int i = 0;
        while(j < fruits.length){
             if(!map.containsKey(fruits[j])){
                  map.put(fruits[j], 0);
             }
             map.put(fruits[j], map.get(fruits[j]) + 1);

             while(map.size() > 2){
                
              map.put(fruits[i], map.get(fruits[i]) - 1);

                  if(map.get(fruits[i]) == 0){
                      map.remove(fruits[i]);
                  }
                 i++;
             }

            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}