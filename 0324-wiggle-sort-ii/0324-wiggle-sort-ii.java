class Solution {
    void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) / 2);

        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
    }
    private int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) return nums[pos];
            else if (pos + 1 < k) left = pos + 1;
            else right = pos - 1;
        }
    }
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right], l = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) swap(nums, l++, i);
        }
        swap(nums, l, right);
        return l;
    }
    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
