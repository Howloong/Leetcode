from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class UnionFind:
    def __init__(self, n: int):
        self.nodes = [i for i in range(n)]
        self.rank = [1] * n

    def find(self, x: int):
        if x == self.nodes[x]:
            return x
        self.nodes[x] = self.find(self.nodes[x])
        return self.nodes[x]

    def unite(self, x: int, y: int):
        x = self.find(x)
        y = self.find(y)
        if x == y:
            return
        if self.rank[x] < self.rank[y]:
            self.nodes[x] = self.nodes[y]
            self.rank[y] += self.rank[x]
        else:
            self.nodes[y] = self.nodes[x]
            self.rank[x] += self.rank[y]


class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        u = UnionFind(n)
        for edge in edges:
            u.unite(edge[0], edge[1])
        res = 0
        for i in range(n):
            res += n - u.rank[u.find(i)]
        return res >> 1


# leetcode submit region end(Prohibit modification and deletion)
# print(Solution().countPairs(11, [[5, 0], [1, 0], [10, 7], [9, 8], [7, 2], [1, 3], [0, 2], [8, 5], [4, 6], [4, 2]]))
print(Solution().countPairs(7, [[0, 2], [0, 5], [2, 4], [1, 6], [5, 4]]))
print(Solution().countPairs(3, [[0, 1], [0, 2], [1, 2]]))
