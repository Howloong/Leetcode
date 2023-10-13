# leetcode submit region begin(Prohibit modification and deletion)
import math
from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n = len(nums)
        ans = math.inf
        s = 0
        left = 0
        right = 0
        for x in nums:
            s += x
            while s >= target:
                s -= nums[left]
                ans = min(ans, right - left + 1)
                left += 1
            right += 1
        return ans if ans <= n else 0

# leetcode submit region end(Prohibit modification and deletion)
