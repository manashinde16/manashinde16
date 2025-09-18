class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int left = 0, right = 0;
        int maxLen = 0, currentCost = 0;

        while (right < n) {
            currentCost += Math.abs(s.charAt(right) - t.charAt(right));

            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
