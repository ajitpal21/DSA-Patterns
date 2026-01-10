// leetcode 729. My Calendar I ?

// Approach1
class MyCalendar {
     List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<int[]>();
    }
    
    public boolean book(int startTime, int endTime) {
        
          if(bookings.size() == 0){
              bookings.add(new int[]{
                 startTime,
                 endTime - 1
              });
              return true;
          }

          for(int i = 0; i < bookings.size(); i++){
              int s1 = bookings.get(i)[0];
              int e1 = bookings.get(i)[1];
              int s2 = startTime;
              int e2 = endTime - 1;

              if(e1 >= s2 && e2 >= s1){
                  return false;
              }
          }

          bookings.add(new int[]{
              startTime,
              endTime - 1
          });

          return true;
    }
}

// Approach2
class MyCalendar {
     Map<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);

        int bookings = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
              bookings = bookings + entry.getValue();

              if(bookings > 1){
                  map.put(startTime, map.get(startTime) - 1);
                  map.put(endTime, map.get(endTime) + 1);

                  if(map.get(startTime) == 0){
                      map.remove(startTime);
                  }

                  if(map.get(endTime) == 0){
                      map.remove(endTime);
                  }

                  return false;
              }
        }

        return true;
    }
}
