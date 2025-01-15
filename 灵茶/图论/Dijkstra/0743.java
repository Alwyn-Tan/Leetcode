import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE / 2);
        }

        for (int[] time : times) {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE / 2);

        dis[k - 1] = 0;

        boolean[] visited = new boolean[n];
        // visited[k-1] = true;

        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (x == -1 || dis[j] < dis[x])) {
                    x = j;
                }
            }

            visited[x] = true;
            for (int j = 0; j < n; j++) {
                if (graph[x][j] != Integer.MAX_VALUE) {
                    dis[j] = Math.min(dis[j], dis[x] + graph[x][j]);
                }
            }
        }

        int ans = Arrays.stream(dis).max().getAsInt();
        return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}