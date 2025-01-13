import java.util.*;

class UnionFind {

    private Map<Integer, Integer> father;

    private int size;

    public UnionFind() {
        father = new HashMap<Integer, Integer>();
        size = 0;
    }

    public void add(int x) {
        if (!father.containsKey(x)) {
            father.put(x, null);
            size++;
        }
    }

    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            father.put(rootX, rootY);
            size--;
        }
    }

    public int find(int x) {
        int root = x;
        while (father.get(root) != null) {
            root = father.get(root);
        }

        while (x != root) {
            int original_father = father.get(x);
            father.put(x, root);
            x = original_father;
        }

        return root;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int getSize() {
        return size;
    }

}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionFind UF = new UnionFind();
        for (int i = 0; i < isConnected.length; i++) {
            UF.add(i);
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    UF.merge(i, j);
                }
            }
        }

        return UF.getSize();
    }
}
