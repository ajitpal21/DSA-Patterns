// leetcode 295. Find Median from Data Stream ?

class MedianFinder {

    // for max heap for left half
    PriorityQueue<Integer> left;
    // for min heap for right half
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> b - a); // max heap
        right = new PriorityQueue<>();               // min heap
    }

    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());

        if(right.size() > left.size()) {
            left.add(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }
}