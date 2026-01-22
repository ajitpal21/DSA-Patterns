// leetcode 2231. Largest Number After Digit Swaps by Parity ?

import java.util.PriorityQueue;

class Solution {
    public int largestInteger(int num) {

        String s = String.valueOf(num);

        // Max heaps for even and odd digits
        PriorityQueue<Integer> evenHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> oddHeap = new PriorityQueue<>((a, b) -> b - a);

        //Separate digits by parity
        for (char ch : s.toCharArray()) {
            int digit = ch - '0';
            if (digit % 2 == 0) {
                evenHeap.add(digit);
            } else {
                oddHeap.add(digit);
            }
        }

        //Build the largest number
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';
            if (digit % 2 == 0) {
                result.append(evenHeap.poll());
            } else {
                result.append(oddHeap.poll());
            }
        }

        return Integer.parseInt(result.toString());
    }
}
