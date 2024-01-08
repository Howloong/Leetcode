from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        def getDistance(point1, point2):
            return pow(point1[0] - point2[0], 2) + pow(point1[1] - point2[1], 2)

        ans = 0
        for i in points:
            c = defaultdict(int)
            for j in points:
                t = getDistance(i, j)
                c[t] += 1
            ans += sum(d * (d - 1) for d in c.values())
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().numberOfBoomerangs([[0, 0], [1, 0], [2, 0]]))
print(Solution().numberOfBoomerangs([[1,1],[2,2],[3,3]]))
print(Solution().numberOfBoomerangs([[1,1]]))
