from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        res = []
        for i, num1 in enumerate(nums):
            if i > 0 and num1 == nums[i - 1]:
                continue
            for j in range(i + 1, len(nums)):
                num2 = nums[j]
                if j > i + 1 and num2 == nums[j - 1]:
                    continue
                k = j + 1
                l = n - 1
                while k < l:
                    t = num1 + num2 + nums[k] + nums[l]
                    if t == target:
                        res.append([num1, num2, nums[k], nums[l]])
                        while k < l and nums[k] == nums[k + 1]:
                            k += 1
                        while k < l and nums[l] == nums[l - 1]:
                            l -= 1
                        k += 1
                        l -= 1
                    elif t > target:
                        l -= 1
                    else:
                        k += 1
        return res


# leetcode submit region end(Prohibit modification and deletion)
# print(Solution().fourSum([1, 0, -1, 0, -2, 2], 0))
print(Solution().fourSum([2, 2, 2, 2, 2], 8))
