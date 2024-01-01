from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def buyChoco(self, prices: List[int], money: int) -> int:
        prices.sort()
        t = money - prices[0] - prices[1]
        return money if t < 0 else t


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().buyChoco([1, 2, 2], 3))
print(Solution().buyChoco([3, 2, 3], 3))
