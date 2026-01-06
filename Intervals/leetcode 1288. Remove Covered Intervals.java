// leetcode 1288. Remove Covered Intervals ?

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // sort the intervals
        Arrays.sort(intervals, (a, b) -> {
              if(a[0] == b[0]){
                  return b[1] - a[1];
              }
              return a[0] - b[0];
        });
        
        // create res Array
        List<int[]> res = new ArrayList<>();
        
        // add first value of intervals into the result
        res.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            // if [a,b] is covered by [c,d]
               if(res.get(res.size() - 1)[0] <= intervals[i][0] && intervals[i][1] <= res.get(res.size() - 1)[1]){
                     continue;
               }else{
                   res.add(intervals[i]); // add in the result
               }
        }
         int count = 0;
         for(int i = 0; i < res.size(); i++){
               count++;
         }
        
        return count;
    }
}