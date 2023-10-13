from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 2
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < nums[right]:
                right = mid - 1
            elif nums[mid] > nums[right]:
                left = mid + 1
            else:
                right -= 1
        return nums[left]


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().findMin([3, 1]) == 1)
print(Solution().findMin([1, 3, 5]) == 1)
print(Solution().findMin([2, 2, 2, 0, 1]) == 0)
