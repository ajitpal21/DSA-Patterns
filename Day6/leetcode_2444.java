// leetcode 2444. Count Subarrays With Fixed Bounds ?

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastMin = -1;   // last index nums[i] == minK
        int lastMax = -1;   // last index nums[i] == maxK
        int lastBad = -1;   // last index nums[i] < minK or nums[i] > maxK

        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastBad = i;
            }

            if (nums[i] == minK) {
                lastMin = i;
            }

            if (nums[i] == maxK) {
                lastMax = i;
            }

            int validEnd = Math.min(lastMin, lastMax);
            if (validEnd > lastBad) {
                count += validEnd - lastBad;
            }
        }

        return count;
    }
}
