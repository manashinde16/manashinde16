class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int totalSum = 0;
        int currentMax = 0;
        int currentMin = 0;
        int maxSum = nums[0];
        int minSum = nums[0];

        for (int num : nums) {
            totalSum += num;
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }
        if (minSum == totalSum) {
            return maxSum;
        }
        return Math.max(maxSum, totalSum - minSum);
    }
}