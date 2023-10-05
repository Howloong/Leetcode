from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 2
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] < nums[-1]:
                right = mid - 1
            else:
                left = mid + 1
        if target < nums[left] or target > nums[right]:
            return -1

        def binarySearch(nums, left, right, target):
            while left <= right:
                mid = left + (right - left) // 2
                if nums[mid] == target:
                    return mid
                if nums[mid] > target:
                    right = mid - 1
                else:
                    left = mid + 1
            return -1

        t = binarySearch(nums, 0, right, target)
        if t != -1:
            return t
        return binarySearch(nums, left, len(nums) - 1, target)

# leetcode submit region end(Prohibit modification and deletion)
s=Solution()
print(s.search([4,5,6,7,0,1,2],0))
print(s.search([4,5,6,7,0,1,2],3))
print(s.search([1],0))