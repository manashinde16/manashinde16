class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        return countWhileMergeSort(prefix, 0, prefix.length, lower, upper);
    }

    private int countWhileMergeSort(long[] prefix, int left, int right, int lower, int upper) {
        if (right - left <= 1) return 0;
        int mid = (left + right) / 2;
        
        int count = countWhileMergeSort(prefix, left, mid, lower, upper) 
                  + countWhileMergeSort(prefix, mid, right, lower, upper);
        
        int j = mid, k = mid, t = mid;
        long[] cache = new long[right - left];
        int r = 0;
        
        for (int i = left; i < mid; i++) {
            while (k < right && prefix[k] - prefix[i] < lower) k++;
            while (j < right && prefix[j] - prefix[i] <= upper) j++;
            count += j - k;
            
            while (t < right && prefix[t] < prefix[i]) cache[r++] = prefix[t++];
            cache[r++] = prefix[i];
        }
        System.arraycopy(cache, 0, prefix, left, r);
        return count;
    }
}
