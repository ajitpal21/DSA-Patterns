// leetcode 321. Create Maximum Number ?

class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] best = new int[k];

        for (int x = Math.max(0, k - n); x <= Math.min(k, m); x++) {

            int[] part1 = pickMax(nums1.clone(), x);
            int[] part2 = pickMax(nums2.clone(), k - x);

            int[] merged = merge(part1, part2);

            if (isGreater(merged, 0, best, 0)) {
                best = merged;
            }
        }
        return best;
    }


   private int[] pickMax(int[] nums, int k) {
    int n = nums.length;
    int drop = n - k;
    int[] stack = new int[k];
    int top = -1;

    for (int i = 0; i < n; i++) {
        int num = nums[i];

        while (top >= 0 && stack[top] < num && drop > 0) {
            top--;
            drop--;
        }

        if (top + 1 < k) {
            stack[++top] = num;
        } else {
            drop--;  
        }
    }
    return stack;
}
     private int[] merge(int[] a, int[] b) {
        int i = 0, j = 0, idx = 0;
        int[] result = new int[a.length + b.length];

        while (i < a.length || j < b.length) {
            if (j == b.length || (i < a.length && isGreater(a, i, b, j))) {
                result[idx++] = a[i++];
            } else {
                result[idx++] = b[j++];
            }
        }
        return result;
    }


    private boolean isGreater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }
        if (j == b.length) return true;
        if (i == a.length) return false;
        return a[i] > b[j];
    }
}
