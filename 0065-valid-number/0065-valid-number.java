class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        boolean numAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                numSeen = true;
                if (eSeen) numAfterE = true;
            } 
            else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } 
            else if (c == '.') {
                if (dotSeen || eSeen) return false;
                dotSeen = true;
            } 
            else if (c == 'e' || c == 'E') {
                if (eSeen || !numSeen) return false;
                eSeen = true;
                numAfterE = false; 
            } 
            else {
                return false;
            }
        }
        return numSeen && numAfterE;
    }
}
