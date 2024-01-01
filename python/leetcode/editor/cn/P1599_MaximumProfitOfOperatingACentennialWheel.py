from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperationsMaxProfit(self, customers: List[int], boardingCost: int, runningCost: int) -> int:
        profit, rest, count, ans, i, _max = 0, 0, 0, 0, 0, -1
        while rest > 0 or i < len(customers):
            rest += customers[i] if i < len(customers) else 0
            t = min(4, rest)
            rest -= t
            profit += (boardingCost * t - runningCost)
            i += 1
            if profit > _max:
                _max = profit
                ans = i
        return ans if _max > 0 else -1
# leetcode submit region end(Prohibit modification and deletion)
