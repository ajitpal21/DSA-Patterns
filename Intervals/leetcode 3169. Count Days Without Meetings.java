// leetcode 3169. Count Days Without Meetings ?

class Solution {
    public int countDays(int days, int[][] meetings) {
        // first sort the Array
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>(); // create a result ArrayList
        res.add(meetings[0]); 

        // merge the inetevals
        for(int i = 1; i < meetings.length; i++){
              if(meetings[i][0] <= res.get(res.size() - 1)[1]){
                  res.get(res.size() - 1)[0] = Math.min(meetings[i][0], res.get(res.size() - 1)[0]);
                  res.get(res.size() - 1)[1] = Math.max(meetings[i][1], res.get(res.size() - 1)[1]);
              }else{
                  res.add(meetings[i]);
              }
        }
        
        // find the count 
        int gap = 0;
        for(int i = 1; i < res.size(); i++){
              gap = gap + res.get(i)[0] - res.get(i - 1)[1] - 1;
        }
        gap = gap + res.get(0)[0] - 1;
        gap = gap + days - res.get(res.size() - 1)[1];

     return gap;
    }
}
