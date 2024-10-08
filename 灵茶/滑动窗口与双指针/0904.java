class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int right = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.computeIfPresent(fruits[left], (k, v) -> v - 1 == 0 ? null : v - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}