class Solution {
    List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<String> result) {
        if (path.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;
            String segment = s.substring(start, start + len);

            if (isValid(segment)) {
                path.add(segment);
                backtrack(s, start + len, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}
