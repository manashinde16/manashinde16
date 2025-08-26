class Solution {
    String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] parts = path.split("/");

        for (String dir : parts) {
            if (dir.equals("") || dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.insert(0, "/" + dir);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}