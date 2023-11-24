from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestAlternatingSubarray(self, nums: List[int], threshold: int) -> int:
        i, j = 0, 0
        n = len(nums)
        res = 0
        while i < n:
            if nums[i] % 2 != 0 or nums[i] > threshold:
                i += 1
                continue
            j = i
            while j < n - 1 and nums[j] % 2 != nums[j + 1] % 2 and nums[j + 1] <= threshold:
                j += 1
            res = max(res, j - i + 1)
            i = j + 1
        return res
        # leetcode submit region end(Prohibit modification and deletion)


print(Solution().longestAlternatingSubarray([3, 2, 5, 4], 5))
print(Solution().longestAlternatingSubarray([1, 2], 2))
print(Solution().longestAlternatingSubarray([2, 3, 4, 5], 4))
