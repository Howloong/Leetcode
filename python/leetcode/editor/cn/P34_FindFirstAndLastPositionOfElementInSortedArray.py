# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1, -1]
        left = 0
        right = len(nums) - 1
        res = []
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        res.append(left)
        left = res[0]
        if left == len(nums) or nums[left] != target:
            return [-1, -1]
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] <= target:
                left = mid + 1
            else:
                right = mid - 1
        res.append(left - 1)

        return res


# leetcode submit region end(Prohibit modification and deletion)
s = Solution
# print(s.searchRange(s, [5, 7, 7, 8, 8, 10], 8))
print(s.searchRange(s, [5, 7, 7, 8, 8, 10], 6))
# print(s.searchRange(s, [], 6))
# print(s.searchRange(s, [2, 2], 3))
