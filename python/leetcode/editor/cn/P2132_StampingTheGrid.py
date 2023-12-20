from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def possibleToStamp(self, grid: List[List[int]], stampHeight: int, stampWidth: int) -> bool:
        for i, row in enumerate(grid):
            cnt = 0
            for j, g in enumerate(row):
                if g:
                    if 0 < cnt < stampWidth:
                        return False
                    cnt = 0
                else:
                    cnt += 1
            if 0 < cnt < stampWidth:
                return False
        for j in range(len(grid[0])):
            cnt = 0
            for i in range(len(grid)):
                if grid[i][j]:
                    if 0 < cnt < stampHeight:
                        return False
                    if cnt and 0 < j < len(grid[0]) - 1:
                        if (grid[i - 1][j - 1]) and sum(
                                sum(grid[k][j:j + stampWidth]) for k in range(i - stampHeight, i)):
                            return False
                        if (grid[i - 1][j + 1]) and sum(
                                sum(grid[k][j - stampWidth + 1:j + 1]) for k in range(i - stampHeight, i)):
                            return False
                    cnt = 0
                else:
                    cnt += 1
                    if cnt == stampHeight and 0 < j < len(grid[0]) - 1:
                        if (grid[i - stampHeight + 1][j - 1]) and sum(
                                sum(grid[k][j:j + stampWidth]) for k in range(i - stampHeight + 1, i + 1)):
                            return False
                        if (grid[i - stampHeight + 1][j + 1]) and sum(
                                sum(grid[k][j - stampWidth + 1:j + 1]) for k in
                                range(i - stampHeight + 1, i + 1)):
                            return False
            if 0 < cnt < stampHeight:
                return False
        return True

# leetcode submit region end(Prohibit modification and deletion)
