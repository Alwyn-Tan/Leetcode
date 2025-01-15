class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees = [0 for _ in range(numCourses)]
        adjacency = [[] for _ in range(numCourses)]
        queue = []
        index = 0
        for i, j in prerequisites:
            indegrees[i] += 1
            adjacency[j].append(i)

        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                queue.insert(0, indegrees[i])
        
        while queue:
            node = queue.pop()
            index += 1
            for nxt in adjacency[node]:
                indegrees[nxt] -= 1
                if indegrees[nxt] == 0:
                    queue.insert(0, nxt)
        
        return index == numCourses
        
