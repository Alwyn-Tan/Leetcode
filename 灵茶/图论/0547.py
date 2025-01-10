class UnionFind:
    def __init__(self):
        self.father = {}
        self.size = 0
    
    def find(self, x):
        root = x

        while self.father[root] != None:
            root = self.father[root]
        
        while root != x:
            original_father = self.father[x]
            self.father[x] = root
            x = original_father

        return root
    
    def merge( self, x, y):
        root_x, root_y = self.find(x), self.find(y)

        if root_x != root_y:
            self.father[root_x] = root_y
            self.size -= 1
        
    def is_connected(self, x, y):
        return self.find(x) == self.find(y)
    
    def add(self, x):
        if x not in self.father:
            self.father[x] = None
            self.size += 1

class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        uf = UnionFind()
        for i in range(len(M)):
            uf.add(i)
            for j in range(i):
                if M[i][j]:
                    uf.merge(i, j)
        
        return uf.size