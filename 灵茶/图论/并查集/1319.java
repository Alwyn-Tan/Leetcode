
class Solution {
    private int[] S;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        S = new int[n];
        for (int i = 0; i < n; i++) {
            S[i] = i;
        }

        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }
        int count = 0;
        for (int i = 0; i < S.length; i++) {
            if (S[i] != i) {
                count++;
            }
        }

        return n - 1 - count;

    }

    private int find(int x) {
        if (S[x] != x) {
            S[x] = find(S[x]);
        }
        return S[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            S[rootX] = rootY;
        }
    }
}