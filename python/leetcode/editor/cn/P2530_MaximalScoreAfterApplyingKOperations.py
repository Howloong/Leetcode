import heapq
from math import floor
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        nums = [-n for n in nums]
        heapq.heapify(nums)
        res = 0
        for i in range(k):
            t = heapq.heappop(nums)
            res -= t
            heapq.heappush(nums, floor(t / 3))
        return res
    # leetcode submit region end(Prohibit modification and deletion)


print(Solution().maxKelements([10, 10, 10, 10, 10], 5))
print(Solution().maxKelements([1, 10, 3, 3, 3], 3))
