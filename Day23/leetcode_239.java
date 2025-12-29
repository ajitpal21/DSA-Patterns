// leetcode 239. Sliding Window Maximum ?

// Brute force Approach which gives Time Limit Exceeded
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         int n = nums.length;
       
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= n-k; i++){
            int maxi = nums[i];

            for(int j = i; j <= i+k-1;j++){
                maxi = Math.max(maxi,nums[j]);
            }
            list.add(maxi);
        }
        int result[] = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
             result[i] = list.get(i);
        }
        return result;
  }
}

// Optimize Approach Using Sliding Window Approach 
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if (i >= k - 1) {
                result[ri++] = nums[dq.peek()];
            }
        }

        return result;
    }
}
