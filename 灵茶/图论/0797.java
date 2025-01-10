import java.util.*;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(graph, 0);
        return ans;
    }

    public void dfs(int[][] graph, int i) {
        if (i == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j : graph[i]) {
            path.add(j);
            dfs(graph, j);
            path.remove(path.size() - 1);
        }
    }
}