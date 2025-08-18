class Solution {
    public String makeLargestSpecial(String s) {
        List<String> subs = new ArrayList<>();
        int count = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;

            if (count == 0) {
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                subs.add("1" + inner + "0");
                start = i + 1;
            }
        }
        Collections.sort(subs, Collections.reverseOrder());
        StringBuilder result = new StringBuilder();
        for (String str : subs) {
            result.append(str);
        }
        return result.toString();
    }
}
