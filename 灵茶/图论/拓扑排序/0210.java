import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int index = 0;
        List<List<Integer>> adjacency = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            indegrees[pre[0]]++;
            adjacency.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int item = queue.poll();
            ans[index] = item;
            index++;
            for (int nxt : adjacency.get(item)) {
                indegrees[nxt]--;
                if (indegrees[nxt] == 0) {
                    queue.add(nxt);
                }
            }
        }
        return numCourses == index ? ans : new int[0];

    }
}