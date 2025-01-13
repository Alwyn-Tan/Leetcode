import java.util.Arrays;

class Solution {

    private int[] S;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        S = new int[n];

        Arrays.fill(S, -1);

        for (int[] e : edges) {
            union(e[0], e[1]);
        }

        return find(source) == find(destination);

    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        S[x] = y;
    }

    private int find(int x) {
        int root = x;
        while (S[root] >= 0) {
            root = S[root];
        }
        while (root != x) {
            int temp = S[x];
            S[x] = root;
            x = temp;
        }
        return root;
    }
}