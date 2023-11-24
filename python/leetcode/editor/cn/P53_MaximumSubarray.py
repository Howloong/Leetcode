from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        ans = nums[0]
        s = 0
        for num in nums:
            if s > 0:
                s += num
            else:
                s = num
            ans = max(s, ans)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
