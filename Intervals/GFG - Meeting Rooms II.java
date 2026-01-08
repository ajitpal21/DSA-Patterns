// GFG - Meeting Rooms II ?

class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        
        Map<Integer, Integer> map = new TreeMap<>();
        
        int len = start.length;
        
        for(int i = 0; i < len; i++){
              map.put(start[i], map.getOrDefault(start[i], 0) + 1);
              map.put(end[i], map.getOrDefault(end[i], 0) - 1);
        }
        
        int bookings = 0;
        int max = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
              bookings = bookings + entry.getValue();
              
              max = Math.max(max, bookings);
        }
        
        return max;
    }
}
