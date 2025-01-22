class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        for (int[] node : graph){
            Arrays.fill(node, Integer.MAX_VALUE / 2);
        }

        for(int [] edge: edges ){
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        int [][] distance = graph;
        for(int k=0;k<n;k++){
            for( int i = 0; i < n; i++){
                for(int j=0;j<n;j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int ans = 0;
        int minCount = Integer.MAX_VALUE;
        for( int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if( i != j && distance[i][j] <= distanceThreshold){
                    count++;
                }
            }
                          if(count <= minCount){
                    minCount = count;
                    ans = i;
                }
        }
        return ans;
    }
}