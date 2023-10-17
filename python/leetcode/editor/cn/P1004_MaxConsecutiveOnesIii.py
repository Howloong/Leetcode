from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        n = len(nums)
        res = 0
        pre_sum = [0] * (n + 1)
        for idx, num in enumerate(nums):
            pre_sum[idx + 1] = pre_sum[idx] + (not num)
        for right in range(1,n+1):
            left = 0
            t = pre_sum[right] - k
            temp = right
            while left <= right:
                mid = (left + right) // 2
                if pre_sum[mid] >= t:
                    right = mid - 1
                else:
                    left = mid + 1
            res = max(res, temp - left )
        return res
        # leetcode submit region end(Prohibit modification and deletion)


print(Solution().longestOnes([0, 0, 0, 0], 0))
print(Solution().longestOnes([0, 0, 0, 1], 4))
print(Solution().longestOnes([1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], 2))
print(Solution().longestOnes([0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1], 3))
