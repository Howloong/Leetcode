from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        path = []
        n = len(nums)

        def dfs(index: int) -> None:
            ans.append(path.copy())
            if index == n:
                return
            for i in range(index, n):
                path.append(nums[i])
                dfs(i+1)
                path.pop()

        dfs(0)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().subsets([1, 2, 3]))
