from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        left, right = 1, max(time) * totalTrips

        def func(a: int):
            return sum(a // t for t in time)

        while left <= right:
            mid = (left + right) // 2
            if func(mid) < totalTrips:
                left = mid + 1
            else:
                right = mid - 1
        return left


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minimumTime([1, 2, 3], 5))
