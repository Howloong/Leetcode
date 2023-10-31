from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def smallestMissingValueSubtree(self, parents: List[int], nums: List[int]) -> List[int]:
        n = len(parents)
        ans = [1] * n
        if 1 not in nums:
            return ans
        tree = [[] for _ in range(n)]
        for i in range(1, n):
            tree[parents[i]].append(i)
        vis = set()

        def dfs(x: int):
            vis.add(nums[x])
            for son in tree[x]:
                if nums[son] not in vis:
                    dfs(son)

        mex = 2
        node = nums.index(1)
        while node >= 0:
            dfs(node)
            while mex in vis:
                mex += 1
            ans[node] = mex
            node = parents[node]
        return ans


# leetcode submit region end(Prohibit modification and deletion)
# print(Solution().smallestMissingValueSubtree([-1, 0, 0, 2], [1, 2, 3, 4]))
print(Solution().smallestMissingValueSubtree([-1, 0, 1, 0, 3, 3], [5, 4, 6, 2, 1, 3]))
