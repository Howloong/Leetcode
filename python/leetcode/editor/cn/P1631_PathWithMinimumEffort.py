from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m = len(heights)
        n = len(heights[0])
        delta = 0

        def dfs(_fromX: int, _fromY: int, visited: List[List[bool]], thresh: int) -> bool:
            nonlocal delta
            if _fromX >= m or _fromY >= n or _fromY < 0 or _fromX < 0:
                return False
            if _fromX == m - 1 and _fromY == n - 1:
                return True

            for x, y, in ((1, 0), (0, 1), (-1, 0), (0, -1),):
                newX = _fromX + x
                newY = _fromY + y
                if 0 <= newX < m and 0 <= newY < n and not visited[newX][newY]:
                    delta = abs(heights[_fromX][_fromY] - heights[newX][newY])
                    if delta <= thresh:
                        visited[_fromX][_fromY] = True
                        if dfs(newX, newY, visited, thresh):
                            return True
            return False

        left, right = 0, 10 ** 6 + 1
        while left <= right:
            mid = (left + right) // 2
            visited = [[False] * n for _ in range(m)]
            visited[0][0] = True
            if dfs(0, 0, visited, mid):
                right = mid - 1
            else:
                left = mid + 1

        return left
        # leetcode submit region end(Prohibit modification and deletion)


print(
    Solution().minimumEffortPath())
print(Solution().minimumEffortPath([[1, 10, 6, 7, 9, 10, 4, 9]]))
print(Solution().minimumEffortPath(
    [[8, 3, 2, 5, 2, 10, 7, 1, 8, 9], [1, 4, 9, 1, 10, 2, 4, 10, 3, 5], [4, 10, 10, 3, 6, 1, 3, 9, 8, 8],
     [4, 4, 6, 10, 10, 10, 2, 10, 8, 8], [9, 10, 2, 4, 1, 2, 2, 6, 5, 7], [2, 9, 2, 6, 1, 4, 7, 6, 10, 9],
     [8, 8, 2, 10, 8, 2, 3, 9, 5, 3], [2, 10, 9, 3, 5, 1, 7, 4, 5, 6], [2, 3, 9, 2, 5, 10, 2, 7, 1, 8],
     [9, 10, 4, 10, 7, 4, 9, 3, 1, 6]]))
print(Solution().minimumEffortPath([[1, 2, 3], [3, 8, 4], [5, 3, 5]]))
print(Solution().minimumEffortPath([[1, 2, 2], [3, 8, 2], [5, 3, 5]]))
