from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dp = [-prices[0], 0, 0, 0]
        for i in range(1, len(prices)):
            temp1 = dp[0]
            temp2 = dp[2]
            dp[0] = max(dp[0], max(dp[1], dp[3]) - prices[i])
            dp[1] = max(dp[1], dp[3])
            dp[2] = temp1 +prices[i]
            dp[3] = temp2
        return max(dp[1], dp[2], dp[3])


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.maxProfit([1, 2, 3, 0, 2]))
