# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumPerimeter(self, neededApples: int) -> int:
        left, right = 0, 10 ** 5

        def func(n: int) -> int:
            return 2 * n * (n + 1) * (2 * n + 1)

        while left <= right:
            mid = (left + right) // 2
            if func(mid) >= neededApples:
                right = mid - 1
            else:
                left = mid + 1
        return left * 8


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minimumPerimeter(1))
print(Solution().minimumPerimeter(13))
print(Solution().minimumPerimeter(1000000000))
