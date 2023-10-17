from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countPairs(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        res = 0
        nums.sort()
        while left < right:
            t = nums[left] + nums[right]
            if t < target:
                res += right - left
                left += 1
            else:
                right -= 1
        return res


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().countPairs([-1, 1, 2, 3, 1], 2))
print(Solution().countPairs([-6, 2, 5, -2, -7, -1, 3], -2))
