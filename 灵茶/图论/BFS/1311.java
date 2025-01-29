class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(id);
        visited.add(id);
        int len = 0;
        while (!queue.isEmpty() && len < level) {
            int node = queue.poll();
            for (int i = 0; i < queue.size(); i++) {
                for (int j = 0; j < friends[node].length; j++) {
                    if (!visited.contains(friends[node][j])) {
                        queue.add(friends[node][j]);
                        visited.add(friends[node][j]);
                    }
                }
            }
            len++;
        }

        Map<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<String> videos = watchedVideos.get(node);
            for (String video : videos) {
                map.merge(video, 1, Integer::sum);
            }
        }

        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>((t1, t2) -> {
            if (t1.getValue().equals(t2.getValue())) {
                return t1.getKey().compareTo(t2.getKey());
            } else {
                return t1.getValue().compareTo(t2.getValue());
            }
        });

        map.forEach((key, value) -> pq.add(new Pair<>(key, value)));
        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll().getKey());
        }
        return ans;
    }
}