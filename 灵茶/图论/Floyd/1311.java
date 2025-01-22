class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = watchedVideos.size();
        int[][] distance = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE / 2);
        }
        for(int i =0;i<n;i++){
            distance[i][i] = 0;
            for(int j:friends[i]){
                distance[i][j] = 1;
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for( int i=0;i<n;i++){
            if(distance[id][i] == level){
                for(String video: watchedVideos.get(i)){
                    map.merge(video, 1, Integer::sum);
                }
            }
        }
        
        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>((t1, t2)->{
            if(t1.getValue().equals(t2.getValue())){
                return t1.getKey().compareTo(t2.getKey());
            }else{
                return t1.getValue().compareTo(t2.getValue());
            }
        });

        map.forEach((key, value)->pq.add(new Pair<>(key, value)));
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().getKey());
        }
        return ans;
    }
}