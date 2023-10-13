from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sumDistance(self, nums: List[int], s: str, d: int) -> int:
        mod = 10 ** 9 + 7
        for i in range(len(nums)):
            if s[i] == 'R':
                nums[i] += d
            else:
                nums[i] -= d
        nums.sort()
        res = 0
        pre_res = 0
        for i in range(1, len(nums)):
            pre_res += (nums[i] - nums[i - 1]) * i % mod
            res += pre_res
            res %= mod
        return res

# leetcode submit region end(Prohibit modification and deletion)
