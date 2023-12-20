from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        first = cost[0]
        second = cost[1]
        for i in range(2, len(cost)):
            t = min(first, second) + cost[i]
            first=second
            second=t
        return min(first,second)
# leetcode submit region end(Prohibit modification and deletion)
