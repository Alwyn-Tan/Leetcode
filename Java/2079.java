class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int ans = 0;
        int curr = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (curr >= plants[i]) {
                curr -= plants[i];
                ans++;
            } else {
                curr = capacity - plants[i];
                ans += i  * 2 + 1;
            }
        }
        return ans;
    }
}