from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minCost(self, nums: List[int], x: int) -> int:
        t = nums[:]
        n = len(nums)
        ans = sum(nums)
        for i in range(1, n):
            for j in range(n):
                t[j] = min(t[j], nums[(j + i) % n])
            ans = min(ans, i * x + sum(t))
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minCost([20, 1, 15], 5))
