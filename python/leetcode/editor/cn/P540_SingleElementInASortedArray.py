from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        n = len(nums)
        left = 0
        right = n - 1
        while left <= right:
            mid = (left + right) // 2
            if mid ^ 1 < n and nums[mid] == nums[mid ^ 1]:
                left = mid + 1
            else:
                right = mid - 1
        return nums[left]
        # leetcode submit region end(Prohibit modification and deletion)


print(Solution().singleNonDuplicate([1]))
print(Solution().singleNonDuplicate([1, 1, 2, 3, 3, 4, 4, 8, 8]))
print(Solution().singleNonDuplicate([1, 2, 2, 3, 3, 4, 4, 8, 8]))
