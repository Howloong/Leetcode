from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        _d = defaultdict(list)
        for road in roads:
            _d[road[0]].append(road[1])
            _d[road[1]].append(road[0])
        ans = 0

        def dfs(x: int, fa: int) -> int:
            size = 1
            for y in _d[x]:
                if y != fa:
                    size += dfs(y, x)
            if x:
                nonlocal ans
                ans += (size + seats - 1) // seats
            return size

        dfs(0, -1)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minimumFuelCost([[0, 1], [0, 2], [0, 3]],5))