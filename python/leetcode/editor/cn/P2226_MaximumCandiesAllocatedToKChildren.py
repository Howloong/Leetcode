from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:

        left, right = 1, max(candies),

        def func(i):
            return sum(candy // i for candy in candies)

        while left <= right:
            mid = (left + right) // 2
            if func(mid) >= k:
                left = mid + 1
            else:
                right = mid - 1
        return left - 1


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maximumCandies([5, 8, 6], 3))
print(Solution().maximumCandies([2, 5], 11))
