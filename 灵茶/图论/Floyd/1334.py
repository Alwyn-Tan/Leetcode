class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        w = [[inf] * n for _ in range(n)]
        for i ,j, weight in edges:
            w[i][j] = w[j][i] = weight
        
        f = w
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    s = f[i][k] + f[k][j]
                    if s < f[i][j]:
                        f[i][j] = s
        
        ans = 0
        min_cnt = inf
        for i in range(n):
            cnt = 0
            for j in range(n):
                if j != i and f[i][j] <= distanceThreshold:
                    cnt += 1
            if cnt <= min_cnt:
                min_cnt = cnt
                ans = i
        
        return ans
