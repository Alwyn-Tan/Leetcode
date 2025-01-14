import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            indegrees[pre[0]]++;
            adjacency.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int item = queue.poll();
            numCourses--;
            for (int nxt : adjacency.get(item)) {
                indegrees[nxt]--;
                if (indegrees[nxt] == 0) {
                    queue.add(nxt);
                }
            }
        }
        return numCourses == 0;
    }

}
