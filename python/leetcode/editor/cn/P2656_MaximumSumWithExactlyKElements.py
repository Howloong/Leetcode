from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximizeSum(self, nums: List[int], k: int) -> int:
        m = max(nums)
        return sum(m + i for i in range(k))


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maximizeSum([1, 2, 3, 4, 5], 3))
