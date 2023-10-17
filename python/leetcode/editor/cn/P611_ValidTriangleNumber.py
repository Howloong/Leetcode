from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums.sort()
        res = 0
        n = len(nums)
        for i in range(n):
            k = i+1
            for j in range(i + 1, n):
                while k+1 < n and nums[k+1] < nums[i] + nums[j]:
                    k += 1
                res += max(0, k - j)
        return res


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().triangleNumber([2, 2, 3, 4]))
print(Solution().triangleNumber([4, 2, 3, 4]))
