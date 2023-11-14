from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxAbsValExpr(self, arr1: List[int], arr2: List[int]) -> int:
        _max = -inf
        n = len(arr1)
        for dx, dy in [(1, 1), (1, -1), (-1, 1), (-1, -1)]:
            _maxv = -inf
            _minv = inf
            for i in range(n):
                t = arr1[i] * dx + arr2[i] * dy + i
                _maxv = max(_maxv, t)
                _minv = min(_minv, t)
            _max = max(_maxv - _minv, _max)
        return _max


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maxAbsValExpr([1, 2, 3, 4], [-1, 4, 5, 6]))
print(Solution().maxAbsValExpr([1,-2], [8,8]))
