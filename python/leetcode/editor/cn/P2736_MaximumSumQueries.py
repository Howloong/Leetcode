from bisect import bisect_left
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumSumQueries(self, nums1: List[int], nums2: List[int], queries: List[List[int]]) -> List[int]:
        nums = sorted(((a, b) for a, b in zip(nums1, nums2)), key=lambda x: -x[0])
        ans = [-1] * len(queries)
        stack = []
        j = 0
        for i, (x, y) in sorted(enumerate(queries), key=lambda x: -x[1][0]):
            while j < len(nums) and nums[j][0] >= x:
                ax, ay = nums[j]
                while stack and stack[-1][1] <= ax + ay:
                    stack.pop()
                if not stack or stack[-1][0] < ay:
                    stack.append((ay, ax + ay))
                j += 1
            p = bisect_left(stack, (y,))
            if p < len(stack):
                ans[i] = stack[p][1]
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maximumSumQueries([4, 3, 1, 2], [2, 4, 9, 5], [[4, 1], [1, 3], [2, 5]]))
