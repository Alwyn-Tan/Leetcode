import java.util.ArrayList;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<Integer>();
        int[] incoming = new int[n];
        for (List<Integer> edge : edges) {
            incoming[edge.get(1)]++;
        }
        for ( int i : incoming){
            if (i == 0){
                ans.add(i);
            }
        }
        return ans;

    }
}