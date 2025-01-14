class Solution {
    private int[] S;

    public int minScore(int n, int[][] roads) {
        S = new int[n + 1];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            S[i] = i;
        }
        for (int[] road : roads) {
            merge(road[0], road[1]);
        }
        int root = find(n);
        for (int[] road : roads) {
            if (find(road[0]) == root && find(road[1]) == root) {
                ans = Math.min(ans, road[2]);
            }
        }
        return ans;
    }

    private int find(int x) {
        if (S[x] != x) {
            S[x] = find(S[x]);
        }
        return S[x];
    }

    private void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            S[rootX] = S[rootY];
        }
    }
}