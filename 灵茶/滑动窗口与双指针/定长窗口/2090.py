class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        if k ==0:
            return nums
        sum = 0
        ans = [0] * len(nums)
        
        for index, num in enumerate(nums):
            sum += num
            if index >= 2 * k:
                ans[index - k] = int (sum / (2 * k + 1))
                sum -= nums[index - 2 * k]
            ans[index] = -1


        return ans



        