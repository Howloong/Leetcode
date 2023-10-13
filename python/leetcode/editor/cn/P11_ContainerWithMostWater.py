# leetcode submit region begin(Prohibit modification and deletion)


class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        left = 0
        right = len(height) - 1
        ans = 0
        while left < right:
            l = height[left]
            r = height[right]
            ans = max(ans, min(l, r) * (right - left))
            if l <= r:
                left += 1
            else:
                right -= 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]))
