from math import ceil
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        left = 1
        right = max(nums)

        def func(div):
            return sum(ceil(num / div) for num in nums)

        while left <= right:
            mid = (left + right) // 2
            if func(mid) > threshold:
                left = mid + 1
            else:
                right = mid - 1
        return left


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().smallestDivisor([1, 2, 5, 9], 6))
print(Solution().smallestDivisor([2, 3, 5, 7, 11], 11))
