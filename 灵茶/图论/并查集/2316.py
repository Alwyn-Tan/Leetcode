class UnionFind():
    def __init__(self, n: int):
        self.S = [i for i in range(n)]
        self.size = [1] * n

    def find(self, x:int) -> int:
        if self.S[x] != x:
            self.S[x] = self.find(self.S[x])
        return self.S[x]
    
    def union(self, x:int, y:int):
        x_root, y_root = self.find(x), self.find(y)

        if x_root != y_root:
            self.S[x_root] = y_root
            self.size[self.S[y_root]] += self.size[self.S[x_root]]
    
    def get_size(self, x: int) -> int:
        return self.size[x]

class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        uf = UnionFind(n)
        result = 0
        for x, y in edges:
            uf.union(x, y)
        for i in range (0, n):
            result += n - uf.get_size(uf.find(i))
        
        return result / 2
        
