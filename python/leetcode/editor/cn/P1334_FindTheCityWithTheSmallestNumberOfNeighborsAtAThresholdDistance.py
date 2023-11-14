from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        ans = 0
        _min = inf
        matrix = [[inf for _ in range(n)] for _ in range(n)]
        for _from, _to, _weight in edges:
            matrix[_from][_to] = _weight
            matrix[_to][_from] = _weight
        for k in range(n):
            matrix[k][k] = 0
            for i in range(n):
                for j in range(n):
                    matrix[i][j] = min(matrix[i][k] + matrix[k][j], matrix[i][j])
        for i in range(n):
            cnt = sum(matrix[i][j] <= distanceThreshold for j in range(n))
            if cnt <= _min:
                _min = cnt
                ans = i
        return ans
        # leetcode submit region end(Prohibit modification and deletion)


n = 1
head = [0] * n
edges = [0] * n
nxt = [0] * n
weights = [0] * n

