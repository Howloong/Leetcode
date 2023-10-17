from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        x = sum(nums) - x
        if x < 0:
            return -1
        n = len(nums)
        res = inf
        left, right = 0, 0
        t = 0
        while right < n:
            t += nums[right]
            while left <= right and t > x:
                t -= nums[left]
                left += 1
            if t == x:
                res = min(n - right + left - 1, res)
            right += 1
        return -1 if res == inf else res


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minOperations([1, 1], 3))
print(Solution().minOperations([5, 2, 3, 1, 1], 5))
print(Solution().minOperations([1, 1, 4, 2, 3], 5))
print(Solution().minOperations([5, 6, 7, 8, 9], 4))
print(Solution().minOperations([3, 2, 20, 1, 1, 3], 10))
