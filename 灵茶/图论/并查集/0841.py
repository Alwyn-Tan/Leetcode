class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = {0}
        queue = [0]

        while queue:
            item = queue.pop()
            for key in rooms[item]:
                if key not in visited:
                    visited.add(key)
                    queue.insert(0, key)
        
        return len(visited) == len(rooms)
            