class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        ans = float("-inf")
        sum = 0
        for index, num in enumerate(nums):
            sum += num

            if index < k - 1:
                continue

            ans = max(ans, sum / k)
            sum -= nums[index - k + 1]

        return ans
            