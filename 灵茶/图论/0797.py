from functools import cache
class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        n = len(graph)

        @cache
        def dfs(node):
            if node == n -1 :
                return[[n - 1]]

            ans = []
            for next in graph[node]:
                for res in dfs(next):
                    ans.append([node] + res)
            return ans
        
        return dfs(0)
