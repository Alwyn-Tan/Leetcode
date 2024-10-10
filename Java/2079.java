class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int ans = 0;
        int start = -1;
        int curr = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (curr >= plants[i]) {
                curr -= plants[i];
                ans++;
            } else {
                curr = capacity;
                ans += (i - start) * 2 + 1;
            }
        }
    }
}