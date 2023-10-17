from math import ceil
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)

        def func(speed: int) -> int:
            return sum(ceil(t / speed) for t in piles)

        while left <= right:
            mid = (left + right) // 2
            t = func(mid)
            if t > h:
                left = mid + 1
            else:
                right = mid - 1
        return left
        # leetcode submit region end(Prohibit modification and deletion)


print(Solution().minEatingSpeed([312884470], 312884469))
# print(Solution().minEatingSpeed([30,11,23,4,20], 5))
# print(Solution().minEatingSpeed([30,11,23,4,20], 5))
