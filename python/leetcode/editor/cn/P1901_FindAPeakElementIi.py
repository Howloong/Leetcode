from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findPeakGrid(self, mat: List[List[int]]) -> List[int]:
        m = len(mat)
        left, right = 0, m - 1
        while left <= right:
            mid = (left + right) // 2
            row = mat[mid]
            j = row.index(max(row))
            if row[j] > (-1 if mid == 0 else mat[mid - 1][j]) and row[j] > (-1 if mid == m - 1 else mat[mid + 1][j]):
                return [mid, j]
            if mid > 0 and row[j] < mat[mid - 1][j]:
                right = mid - 1
            else:
                left = mid + 1
        return [-1, -1]


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().findPeakGrid([[1, 4], [3, 2]]))
print(Solution().findPeakGrid([[10, 20, 15], [21, 30, 14], [7, 16, 32]]))
