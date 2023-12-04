from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        _d = dict()
        m = len(mat)
        n = len(mat[0])
        MOD = 10 ** 5
        _d = {mat[i][j]: i * MOD + j for i in range(m) for j in range(n)}
        c1, c2 = [0] * m, [0] * n
        for idx, num in enumerate(arr):
            t = _d[num]
            i = t // MOD
            j = t - i * MOD
            c1[i], c2[j] = c1[i] + 1, c2[j] + 1
            if c1[i] == n or c2[j] == m:
                return idx
        return -1


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().firstCompleteIndex([1, 4, 5, 2, 6, 3], [[4, 3, 5], [1, 2, 6]]))
print(Solution().firstCompleteIndex([2, 8, 7, 4, 1, 3, 5, 6, 9], [[3, 2, 5], [1, 4, 6], [8, 7, 9]]))
print(Solution().firstCompleteIndex([1, 3, 4, 2], [[1, 4], [2, 3]]))
