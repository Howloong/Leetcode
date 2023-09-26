# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k<=1:
            return 0
        ans = 0
        sum = 1
        left = 0
        for right, num in enumerate(nums):
            sum *= num
            while sum >= k:
                sum /= nums[left]
                left += 1
            ans += right - left + 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
s=Solution
print(s.numSubarrayProductLessThanK(s,[10,5,2,6],100))
