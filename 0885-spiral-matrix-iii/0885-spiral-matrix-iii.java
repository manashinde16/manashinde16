class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int total = rows * cols;
        int[][] result = new int[total][2];
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // right, down, left, up

        int step = 0, index = 0;
        int r = rStart, c = cStart;
        
        result[index++] = new int[]{r, c};
        
        int dirIdx = 0;        
        while (index < total) {
            step++;
            for (int d = 0; d < 2; d++) {
                int[] dir = directions[dirIdx];
                for (int i = 0; i < step; i++) {
                    r += dir[0];
                    c += dir[1];
                    
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[index++] = new int[]{r, c};
                        if (index == total) return result;
                    }
                }
                dirIdx = (dirIdx + 1) % 4;
            }
        } 
        return result;
    }
}
