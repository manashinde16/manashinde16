import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];
                
                if (currentVal != '.') {
                    if (!seen.add("row" + i + currentVal)) {
                        return false;
                    }
                    if (!seen.add("col" + j + currentVal)) {
                        return false;
                    }
                    if (!seen.add("box" + i/3 + "-" + j/3 + currentVal)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}