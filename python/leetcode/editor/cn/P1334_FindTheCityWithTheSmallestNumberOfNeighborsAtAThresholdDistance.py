from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        N, M, idx = 110, 110 * 110, 0
        head, e, next, weights = [-1] * N, [0] * M, [0] * M, [0] * M

        def add(_from: int, _to: int, _weight: int) -> None:
            nonlocal idx
            e[idx] = _to
            next[idx] = head[_from]
            weights[idx] = _weight
            head[_from] = idx
            idx += 1

        def dijkstra(x):
            dist = [inf] * n
            vis = [False] * n


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().findTheCity(4, [[0, 1, 3], [1, 2, 1], [1, 3, 4], [2, 3, 1]], 4))
