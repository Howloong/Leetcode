import math
from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # _max = 0
        # _min = prices[0]
        # for num in prices:
        #     _max = max(_max, num - _min)
        #     _min = min(_min, num)
        # return _max
        dp = [-prices[0], 0]
        for i in range(1, len(prices)):
            dp[0] = max(dp[0], -prices[i])
            dp[1] = max(dp[1], prices[i] + dp[0])
        return dp[1]


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.maxProfit([7, 1, 5, 3, 6, 4]))
