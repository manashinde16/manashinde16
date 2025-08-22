class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int overlap = 0;
            int curMax = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    overlap++;
                    continue;
                }

                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                String slope = dx + "/" + dy;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                curMax = Math.max(curMax, slopeMap.get(slope));
            }

            maxPoints = Math.max(maxPoints, curMax + overlap + 1);
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}