from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:

        def backTracking(nums: List[int], res: List[List[int]], path: List[int], used: List[bool]):
            if len(path) == len(nums):
                res.append(list(path))
                return
            for i in range(len(nums)):
                if used[i]:
                    continue
                used[i] = True
                path.append(nums[i])
                backTracking(nums, res, path, used)
                path.pop()
                used[i] = False

        used = [False] * len(nums)
        res = []
        backTracking(nums, res, [], used)
        return res


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.permute([1, 2, 3]))
