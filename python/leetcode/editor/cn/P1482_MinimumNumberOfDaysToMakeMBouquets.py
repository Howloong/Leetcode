from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        n = len(bloomDay)
        if m * k > n:
            return -1

        def func(day: int) -> bool:
            res = 0
            t = 0
            for i in bloomDay:
                if i <= day:
                    t += 1
                else:
                    res += t // k
                    t = 0
            res += t // k
            return res >= m

        left, right = 0, max(bloomDay)
        while left <= right:
            mid = (left + right) // 2
            if func(mid):
                right = mid - 1
            else:
                left = mid + 1
        return left


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minDays([7, 7, 7, 7, 12, 7, 7], 2, 3))
print(Solution().minDays([1, 10, 3, 10, 2], 3, 1))
print(Solution().minDays([1, 10, 3, 10, 2], 3, 2))
