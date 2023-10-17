from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def func(n):
            res = 0
            t = 0
            for weight in weights:
                if t + weight > n:
                    res += 1
                    t = 0
                t += weight
            return res + 1

        left = 0
        right = 0
        for n in weights:
            left = max(left, n)
            right += n
        while left <= right:
            mid = (left + right) // 2
            if func(mid) > days:
                left = mid + 1
            else:
                right = mid - 1
        return left


# leetcode submit region end(Prohibit modification and deletion)
# print(Solution().shipWithinDays([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 5))
print(Solution().shipWithinDays([3, 2, 2, 4, 1, 4], 3))
