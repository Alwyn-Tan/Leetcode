import java.util.*;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < cardPoints.length - k; i++) {
            sum += cardPoints[i];
        }
        int min = sum;
        int total = sum;
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            total += cardPoints[i];
            sum += cardPoints[i];
            sum -= cardPoints[i - (cardPoints.length - k)];
            min = Math.min(sum, min);
        }
        return total - min;
    }
}