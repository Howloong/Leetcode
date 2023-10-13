import math
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        n = len(nums)
        res = 0
        delta = math.inf
        for i, num in enumerate(nums):
            if i > 0 and num == nums[i - 1]:
                continue
            j = i + 1
            k = n - 1
            while j < k:
                t = num + nums[j] + nums[k]
                m = abs(t - target)
                if m < delta:
                    delta = m
                    res = t
                if t > target:
                    k -= 1
                else:
                    j += 1
        return res


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().threeSumClosest([-1, 2, 1, -4], 1))
print(Solution().threeSumClosest([0, 0, 0], 1))
