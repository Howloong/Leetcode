from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        s = 0
        _window = 0
        n = len(cardPoints)
        for i in range(n - k):
            s += cardPoints[i]
            _window += cardPoints[i]
        ans = _window

        for i in range(n - k, n):
            s += cardPoints[i]
            _window = _window + cardPoints[i] - cardPoints[i - (n - k)]
            ans = min(_window, ans)
        return s - ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maxScore([1, 2, 3, 4, 5, 6, 1], 3))
print(Solution().maxScore([2, 2, 2], 2))
print(Solution().maxScore([9, 7, 7, 9, 7, 7, 9], 7))
print(Solution().maxScore([1, 100, 1], 1))
print(Solution().maxScore([1, 79, 80, 1, 1, 1, 200, 1], 3))
