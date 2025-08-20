class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;

            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int numWords = last - index;
            int numSpaces = maxWidth - totalChars + (numWords - 1);

            if (last == n || numWords == 1) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(" ");
                }
                int remaining = maxWidth - sb.length();
                while (remaining-- > 0) sb.append(" ");
            } else {
                int spaces = (maxWidth - (totalChars - (numWords - 1))) / (numWords - 1);
                int extra = (maxWidth - (totalChars - (numWords - 1))) % (numWords - 1);

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        int spaceCount = spaces + (extra-- > 0 ? 1 : 0);
                        for (int s = 0; s < spaceCount; s++) sb.append(" ");
                    }
                }
            }
            result.add(sb.toString());
            index = last;
        }
        return result;
    }
}
