from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        if n==2:
            return 2
        a, b = 1, 2
        c = 0
        for i in range(3, n + 1):
            c = a + b
            a = b
            b = c
        return c
# leetcode submit region end(Prohibit modification and deletion)
