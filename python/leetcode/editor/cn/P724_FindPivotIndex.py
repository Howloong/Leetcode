from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        s = sum(nums)
        t = 0
        for idx, num in enumerate(nums):
            if (t << 1) + num == s:
                return idx
            t += num
        return -1


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().pivotIndex([1, 7, 3, 6, 5, 6]))
print(Solution().pivotIndex([1, 2, 3]))
