class UnionFind:
    def __init__(self):
        self.S = {}
    
    def find(self, x):
        root = x

        while self.S[root] != None :
            root = self.S[root]

        while root !=x:
            t = self.S[x]
            self.S[x] =  root
            x = t
        
        return root
    
    def union(self, x, y):
        root_x, root_y = self.find(x), self.find(y)

        if root_x != root_y:
            self.S[root_x] = root_y

    def add(self, x):
        if x not in self.S:
            self.S[x] = None

class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        uf = UnionFind()
        for i in range (0, n) :
            uf.add(i)
        
        for edge in edges:
            uf.union(edge[0], edge[1])
        
        return uf.find(source) == uf.find(destination)