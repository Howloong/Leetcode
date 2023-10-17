# leetcode submit region begin(Prohibit modification and deletion)
class Solution:



    def sumOfMultiples(self, n: int) -> int:
        def func(x):
            return x % 3 == 0 or x % 5 == 0 or x % 7 == 0
        return sum(filter(func, (i for i in range(1, n + 1))))


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().sumOfMultiples(7))
