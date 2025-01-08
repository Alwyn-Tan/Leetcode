class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        sum = 0
        ans = 0
        for index, num in enumerate(arr):
            sum += num

            if index < k - 1:
                continue
            
            if sum >= threshold * k:
                ans += 1
            
            sum -= arr[index - k + 1]
        return ans
