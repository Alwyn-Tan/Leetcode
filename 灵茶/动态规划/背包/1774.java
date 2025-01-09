import java.util.*;

class Solution {

    int ans;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        ans = Arrays.stream(baseCosts).min().getAsInt();
        if (ans >= target) {
            return ans;
        }

        for (int baseCost : baseCosts) {
            dfs(toppingCosts, 0, baseCost, target);
        }
        return ans;
    }

    public void dfs(int[] toppingCosts, int depth, int curCost, int target) {
        if (curCost - target > Math.abs(ans - target)) {
            return;
        }
        if (Math.abs(curCost - target) <= Math.abs(ans - target)) {
            if (Math.abs(curCost - target) < Math.abs(ans - target)) {
                ans = curCost;
            } else {
                ans = Math.min(ans, curCost);
            }
        }

        if (depth == toppingCosts.length) {
            return;
        }

        dfs(toppingCosts, depth + 1, curCost, target);
        dfs(toppingCosts, depth + 1, curCost + toppingCosts[depth], target);
        dfs(toppingCosts, depth + 1, curCost + toppingCosts[depth] * 2, target);
    }
}