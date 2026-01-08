// leetcode 732. My Calendar III ?

class MyCalendarThree {
     Map<Integer, Integer> map;

    public MyCalendarThree() {
         map = new TreeMap<Integer, Integer>();
    }
    
    public int book(int startTime, int endTime) {
          int bookings = 0;
          int max = 0;

          map.put(startTime, map.getOrDefault(startTime, 0) + 1);
          map.put(endTime, map.getOrDefault(endTime, 0) - 1);

          for(Map.Entry<Integer, Integer> entry : map.entrySet()){
               bookings = bookings + entry.getValue();

               max = Math.max(max, bookings);
          }

          return max;
    }
}