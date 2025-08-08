function majorityElement(nums: number[]): number {
    let ans = 0;
    let score = 0;
    for (const num of nums) {
        if (score == 0) {
            ans = num;
            score++;
        } else if (ans == num) {
            score++;
        } else {
            score--;
        }
    }
    return ans;
};