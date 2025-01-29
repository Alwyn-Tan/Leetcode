import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.size(); i++) {
            graph.get(i).add(i + 1);
        }
        int[] visited = new int[n];
        for (int i = 0; i < queries.length; i++) {
            graph.get(queries[i][0]).add(queries[i][1]);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            int path = 0;
            visited[0] = 1;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int neighbors : graph.get(cur)) {
                    if (visited[neighbors] == 1) {
                        continue;
                    }
                    path++;
                    if (neighbors == n - 1) {
                        break;
                    }
                    visited[neighbors] = 1;
                    queue.add(neighbors);
                }
            }
        }
        return ans;
    }
}