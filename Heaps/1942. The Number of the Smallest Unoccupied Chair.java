// leetcode 1942. The Number of the Smallest Unoccupied Chair ?

//BruteForce Approach
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetFriendArrivalTime = times[targetFriend][0];

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        int[] chair = new int[times.length];

        for(int i = 0; i < times.length; i++){
             
              for(int j = 0; j < chair.length; j++){
                  
                   if(times[i][0] >= chair[j]){
                     
                     if(targetFriendArrivalTime == times[i][0]){
                          return j;
                     }
                     chair[j] = times[i][1];

                    break;
                   }
              }
        }
        return -1;
    }
}

// Optimize Approach Using MinHeap
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetFriendArrivalTime = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> availableChair = new PriorityQueue<>();
        PriorityQueue<int[]> occupiedChair = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int i = 0; i < times.length; i++){
              availableChair.add(i);  // add all chair in availableChair MinHeap
        }
        
        for(int i = 0; i < times.length; i++){
            
           int aT = times[i][0];
           
           while(!occupiedChair.isEmpty()){
                 if(aT >= occupiedChair.peek()[0]){
                     int[] chair = occupiedChair.poll();
                     availableChair.add(chair[1]);
                 } else{
                      break;
                    }
           }

             int c = availableChair.poll();
            if(targetFriendArrivalTime == times[i][0]){
                return c;
            } 

            occupiedChair.add(new int[]{
                times[i][1],
                c  
            });
          }

    return -1;
    }
}

