// leetcode 1094. Car Pooling ?

// Approach 1
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Map<Integer, Integer> map = new TreeMap<>();

        for(int[] trip : trips){
              int pass = trip[0];
              int start = trip[1];
              int end = trip[2];

              map.put(start, map.getOrDefault(start, 0) + pass);
              map.put(end, map.getOrDefault(end, 0) - pass);
        }

        int passengers = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
              passengers = passengers + entry.getValue();

              if(passengers > capacity){
                  return false;
              }
        }

        return true;
    }
}

// Approach 2
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
    
        int[] buckets = new int[1001];

        for(int[] trip : trips){
              int pass = trip[0];
              int start = trip[1];
              int end = trip[2];

              buckets[start] = buckets[start] + pass;
              buckets[end] = buckets[end] - pass;
        }

        int passengers = 0;

        for(int bucket : buckets){
              passengers = passengers + bucket;

              if(passengers > capacity){
                  return false;
              }
        }

        return true;
    }
}