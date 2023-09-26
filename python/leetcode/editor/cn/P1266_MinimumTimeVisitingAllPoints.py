# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        def get(point1, point2):
            a = abs(point1[0] - point2[0])
            b = abs(point1[1] - point2[1])
            return abs(a - b) + min(a, b)

        n = len(points)
        ans = 0
        for i in range(n - 1):
            ans += get(points[i], points[i + 1])
        return ans


# leetcode submit region end(Prohibit modification and deletion)


s = Solution
print(s.minTimeToVisitAllPoints(s, [[1, 1], [3, 4], [-1, 0]]))
