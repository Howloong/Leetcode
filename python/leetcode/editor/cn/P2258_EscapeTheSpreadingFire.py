from bisect import bisect_left
from typing import List, Tuple


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumMinutes(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        def check(time: int) -> bool:
            f = [(i, j) for i, row in enumerate(grid) for j, value in enumerate(row) if value == 1]
            fire = set(f)  # 存放所有的火

            def spread_fire():
                nonlocal f
                tmp = f  # 备份原来的火
                f = []  # 存放新火
                for i, j in tmp:
                    for x, y in (i, j - 1), (i, j + 1), (i + 1, j), (i - 1, j),:
                        if m > x >= 0 and 0 <= y < n and grid[x][y] == 0 and (x, y) not in fire:
                            fire.add((x, y))
                            f.append((x, y))

            while time and f:
                # 每次扩散新火，
                spread_fire()  # 先扩散time秒
                time -= 1
            if (0, 0) in fire:  # 出发点有火
                return True
            q = [(0, 0)]  # 扩散出发点
            vis = set(q)
            while q:
                tmp = q
                q = []  # 每次扩散新的出发点
                for i, j in tmp:
                    if (i, j) not in fire:
                        for x, y in (i, j - 1), (i, j + 1), (i + 1, j), (i - 1, j),:
                            if m > x >= 0 and 0 <= y < n and grid[x][y] == 0 and (x, y) not in fire and (
                                    x, y) not in vis:
                                if x == m - 1 and y == n - 1:  # 到了终点
                                    return False
                                vis.add((x, y))
                                q.append((x, y))
                spread_fire()  # 每次扩散一分钟的fire
            return True

        ans = bisect_left(range(m * n + 1), True, key=check) - 1
        # True为能烧到，False为不能。如果可以停留t分钟，则一定可以停留小于t分钟；如果不能停留t分钟，则一定不能停留大于t分钟
        # 蓝色为可以烧到，红色为不能，所以ans为left-1
        return ans if ans < m * n else 10 ** 9

    def maximumMinutes2(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        def bfs(q: List[Tuple[int, int]]) -> (int, int, int):
            time = [[-1] * n for _ in range(m)]
            for i, j in q:
                time[i][j] = 0
            t = 1
            while q:
                tmp = q
                q = []
                for i, j in tmp:
                    for x, y in (i, j - 1), (i, j + 1), (i + 1, j), (i - 1, j):
                        if 0 <= x < m and 0 <= y < n and grid[x][y] == 0 and time[x][y] < 0:
                            time[x][y] = t
                            q.append((x,y))
                t += 1
            return time[-1][-1], time[-1][-2], time[-2][-1]  # 终点会不会遍历到和遍历到终点的左边、终点的上边需要的时间

        man_to_house, m1, m2 = bfs([(0, 0)])
        if man_to_house < 0:
            return -1
        fire_to_house, f1, f2 = bfs([(i, j) for i, row in enumerate(grid) for j, v in enumerate(row) if v == 1])
        if fire_to_house < 0:
            return 10 ** 9
        ans = fire_to_house - man_to_house
        if ans < 0:
            return -1
        if f1 - m1 == f2 - m2 == ans or m1 < 0 or m2 < 0:
            return ans - 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maximumMinutes2(
    [[0, 2, 0, 0, 0, 0, 0], [0, 0, 0, 2, 2, 1, 0], [0, 2, 0, 0, 1, 2, 0], [0, 0, 2, 2, 2, 0, 2],
     [0, 0, 0, 0, 0, 0, 0]]))
