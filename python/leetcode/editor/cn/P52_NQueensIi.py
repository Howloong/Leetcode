from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def totalNQueens(self, n: int) -> int:
        def backTracking(row: int) -> int:
            if row == n:
                return 1
            count = 0
            for i in range(n):
                if i in c or row - i in s1 or row + i in s2:
                    continue
                c.add(i)
                t1 = row - i
                t2 = row + i
                s1.add(t1)
                s2.add(t2)
                count += backTracking(row + 1)
                c.remove(i)
                s1.remove(t1)
                s2.remove(t2)
            return count
        s1 = set()
        s2 = set()
        c = set()
        return backTracking(0)
# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.totalNQueens(1))
