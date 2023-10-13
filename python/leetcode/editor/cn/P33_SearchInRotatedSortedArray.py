from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def search(self, nums: List[int], target: int) -> int:
        def is_blue(i: int) -> bool:
            end = nums[-1]
            if nums[i] > end:
                # 说明i在第一段
                return end < target <= nums[i]
                # 当target也>end时，说明target和i在同一段；并且i在target右侧时，说明i及其右侧为蓝色
            return target > end or nums[i] >= target
            # 否则，当target在第一段，i在第二段 或者 target和i都在第二段，并且nums[i]>=target时，
            # i及其右侧为蓝色，其余情况均为红色

        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if is_blue(mid):
                right = mid - 1
            else:
                left = mid + 14
        # 结束时left为理论上等于target的值，也就是蓝色的第一个
        if left >= len(nums) or nums[left] != target:
            return -1
        return left


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.search([4, 5, 6, 7, 0, 1, 2], 0))
print(s.search([4, 5, 6, 7, 0, 1, 2], 3))
print(s.search([1], 1))
print(s.search([1, 3], 1))
