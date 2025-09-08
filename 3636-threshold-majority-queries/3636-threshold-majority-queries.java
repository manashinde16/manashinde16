class Solution {

    static class Query {
        int l, r, t, idx;
        Query(int l, int r, int t, int idx) {
            this.l = l; this.r = r; this.t = t; this.idx = idx;
        }
    }

    private final Map<Integer, Integer> cnt = new HashMap<>();
    private final TreeMap<Integer, TreeSet<Integer>> bucket = new TreeMap<>();

    public int[] subarrayMajority(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;
        int block = Math.max(1, (int) Math.sqrt(n));

        Query[] qs = new Query[q];
        for (int i = 0; i < q; i++) {
            qs[i] = new Query(queries[i][0], queries[i][1], queries[i][2], i);
        }

        Arrays.sort(qs, (a, b) -> {
            int ab = a.l / block, bb = b.l / block;
            if (ab != bb) return ab - bb;
            return (ab % 2 == 0) ? (a.r - b.r) : (b.r - a.r);
        });

        int[] ans = new int[q];
        int curL = 0, curR = -1;

        for (Query qu : qs) {
            int L = qu.l, R = qu.r;

            while (curL > L) add(nums[--curL]);
            while (curR < R) add(nums[++curR]);
            while (curL < L) remove(nums[curL++]);
            while (curR > R) remove(nums[curR--]);

            int maxFreq = bucket.isEmpty() ? 0 : bucket.lastKey();
            ans[qu.idx] = (maxFreq >= qu.t) ? bucket.get(maxFreq).first() : -1;
        }

        return ans;
    }

    private void add(int x) {
        int prev = cnt.getOrDefault(x, 0);
        if (prev > 0) {
            TreeSet<Integer> s = bucket.get(prev);
            if (s != null) {
                s.remove(x);
                if (s.isEmpty()) bucket.remove(prev);
            }
        }
        int now = prev + 1;
        cnt.put(x, now);
        bucket.computeIfAbsent(now, k -> new TreeSet<>()).add(x);
    }

    private void remove(int x) {
        Integer prevObj = cnt.get(x);
        if (prevObj == null) return; 
        int prev = prevObj;

        TreeSet<Integer> s = bucket.get(prev);
        if (s != null) {
            s.remove(x);
            if (s.isEmpty()) bucket.remove(prev);
        }

        int now = prev - 1;
        if (now == 0) {
            cnt.remove(x);
        } else {
            cnt.put(x, now);
            bucket.computeIfAbsent(now, k -> new TreeSet<>()).add(x);
        }
    }
}
