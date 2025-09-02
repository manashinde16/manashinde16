class Solution {
    int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {
            int[] rowSum = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][right];
                }
                maxSum = Math.max(maxSum, maxSubArrayNoLargerThanK(rowSum, k));
                if (maxSum == k) return k;
            }
        }
        return maxSum;
    }

    private int maxSubArrayNoLargerThanK(int[] nums, int k) {
        int prefixSum = 0, max = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        for (int num : nums) {
            prefixSum += num;
            Integer target = set.ceiling(prefixSum - k);
            if (target != null) {
                max = Math.max(max, prefixSum - target);
            }
            set.add(prefixSum);
        }
        return max;
    }
}
