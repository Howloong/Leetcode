from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumMountainRemovals(self, nums: List[int]) -> int:
        n = len(nums)
        pre = [0] * n
        g = []

        def func(x: int) -> int:
            if not g or x > g[-1]:
                g.append(x)
                return len(g)-1
            else:
                left, right = 0, len(g) - 1
                while left <= right:
                    mid = (left + right) // 2
                    if g[mid] >= x:
                        right = mid - 1
                    else:
                        left = mid + 1
                g[left] = x
                return left

        for i in range(n - 1, -1, -1):
            pre[i] = func(nums[i]) + 1
        g.clear()
        ans = 0
        for i in range(n):
            p = func(nums[i]) + 1
            if p >= 2 and pre[i] >= 2:
                ans = max(ans, p + pre[i] - 1)
        return n - ans
        # leetcode submit region end(Prohibit modification and deletion)


print(Solution().minimumMountainRemovals([1, 3, 1]))
print(Solution().minimumMountainRemovals([2, 1, 1, 5, 6, 2, 3, 1]))
