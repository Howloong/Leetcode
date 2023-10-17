from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = nums[0]
        for i in range(1, len(nums)):
            res ^= nums[i]
        return res


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().singleNumber([4, 1, 2, 1, 2]))
