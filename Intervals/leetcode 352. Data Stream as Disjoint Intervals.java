// leetcode 352. Data Stream as Disjoint Intervals ?

class SummaryRanges {

    TreeMap<Integer, int[]> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {
        Integer key = map.floorKey(value);
        if (key != null && map.get(key)[1] >= value) {
            return;
        }

        Integer next = map.ceilingKey(value);

        boolean mergeLeft = false;
        boolean mergeRight = false;

        int start = value;
        int end = value;

        // Check for left interval
        if (key != null && map.get(key)[1] + 1 == value) {
            mergeLeft = true;
            start = map.get(key)[0];
        }

        // Check for right interval
        if (next != null && next == value + 1) {
            mergeRight = true;
            end = map.get(next)[1];
        }

        // Merge the both sides
        if (mergeLeft && mergeRight) {
            int[] left = map.get(key);
            int[] right = map.get(next);

            left[1] = right[1];
            map.remove(next);
        }
        // Merge only the left
        else if (mergeLeft) {
            map.get(key)[1] = value;
        }
        // Merge only the right
        else if (mergeRight) {
            int[] right = map.get(next);
            map.remove(next);
            map.put(value, new int[]{value, right[1]});
        }
        // No merge
        else {
            map.put(value, new int[]{value, value});
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (int[] interval : map.values()) {
            res[i++] = interval;
        }
        return res;
    }
}