class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        char[] arr = s.toCharArray();

        long totalShift = 0;
        for (int i = n - 1; i >= 0; i--) {
            totalShift = (totalShift + shifts[i]) % 26;
            int newChar = (arr[i] - 'a' + (int)totalShift) % 26;
            arr[i] = (char) ('a' + newChar);
        }
        return new String(arr);
    }
}
