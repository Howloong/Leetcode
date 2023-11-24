from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minPathCost(self, grid: List[List[int]], moveCost: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0]),
        dp = grid[0]
        for i in range(1, m):
            dp = [grid[i][j] + min(dp[k] + moveCost[grid[i - 1][k]][j] for k in range(n)) for j in range(n)]
        # for i in range(m - 2, -1, -1):
        #     for j in range(n):
        #         grid[i][j] += min(g + c for g, c in zip(grid[i + 1], moveCost[grid[i][j]]))
        # return min(grid[0])

        return min(dp)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minPathCost([[5, 3], [4, 0], [2, 1]], [[9, 8], [1, 5], [10, 12], [18, 6], [2, 4], [14, 3]]))
