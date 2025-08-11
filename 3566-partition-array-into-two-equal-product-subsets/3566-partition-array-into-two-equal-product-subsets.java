class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        int n = nums.length;

        for (int mask = 1; mask < (1 << n) - 1; mask++) {
            long prod1 = 1;
            long prod2 = 1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    prod1 *= nums[i];
                } else {
                    prod2 *= nums[i];
                }
            }
            if (prod1 == target && prod2 == target) {
                return true;
            }
        }
        return false;
    }
}
