class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                for (int[] dir : directions) {
                    int r = i + dir[0], c = j + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n &&
                        (board[r][c] == 1 || board[r][c] == -1)) {
                        liveNeighbors++;
                    }
                }
                if (board[i][j] == 1) { 
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = -1;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}
