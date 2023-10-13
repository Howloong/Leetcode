# leetcode submit region begin(Prohibit modification and deletion)
from collections import Counter


class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        count = Counter(sum(map(int, str(i))) for i in range(lowLimit, highLimit + 1))
        return max(count.values())


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().countBalls(1, 10))
print(Solution().countBalls(5, 15))
