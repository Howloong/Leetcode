from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        degree = [0] * (len(edges) + 1)
        for edge in edges:
            _from = edge[0] - 1
            _to = edge[1] - 1
            if degree[_from] >= 1:
                return _from + 1
            if degree[_to] >= 1:
                return _to + 1
            degree[_from] += 1
            degree[_to] += 1
        return -1


# leetcode submit region end(Prohibit modification and deletion)
# print(Solution().findCenter([[1,2],[2,3],[4,2]]))
# print(Solution().findCenter([[1, 2], [5, 1], [1, 3], [1, 4]]))
print(Solution().findCenter([[1, 3], [2, 3]]))
