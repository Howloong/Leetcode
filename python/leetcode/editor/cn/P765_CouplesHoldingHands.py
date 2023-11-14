from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        n = len(row)
        m = n // 2
        p = [i for i in range(m)]
        rank = [1] * m

        def find(x: int) -> int:
            return x if p[x] == x else find(p[x])

        def union(x: int, y: int) -> None:
            x = find(x)
            y = find(y)
            if x == y:
                return
            if rank[x] < rank[y]:
                p[x] = y
            else:
                p[y] = x
            if rank[x] == rank[y]:
                rank[x] += 1

        for i in range(0, n, 2):
            union(row[i] // 2, row[i + 1] // 2)

        return m - sum(1 for i in range(m) if i == find(i))


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minSwapsCouples([15, 13, 5, 6, 3, 12, 1, 10, 16, 2, 8, 17, 7, 11, 0, 9, 14, 4]))
print(Solution().minSwapsCouples([0, 2, 6, 1, 4, 7, 5, 3]))
