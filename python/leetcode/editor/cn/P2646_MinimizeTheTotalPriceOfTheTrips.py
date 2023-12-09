from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumTotalPrice(self, n: int, edges: List[List[int]], price: List[int], trips: List[List[int]]) -> int:
        g = [[] for _ in range(n)]
        for x, y in edges:
            g[x].append(y)
            g[y].append(x)

        cnt = [0] * n
        for start, end in trips:
            def dfs(x: int, fa: int) -> bool:
                if x == end:
                    cnt[x] += 1
                    return True  # 找到 end
                for y in g[x]:
                    if y != fa and dfs(y, x):
                        cnt[x] += 1  # x 是 end 的祖先节点，也就在路径上
                        return True
                return False  # 未找到 end
            dfs(start, -1)

        # 类似 337. 打家劫舍 III
        def dfs(x: int, fa: int) -> (int, int):
            not_halve = price[x] * cnt[x]  # x 不变
            halve = not_halve // 2  # x 减半
            for y in g[x]:
                if y != fa:
                    nh, h = dfs(y, x)  # 计算 y 不变/减半的最小价值总和
                    not_halve += min(nh, h)  # x 不变，那么 y 可以不变或者减半，取这两种情况的最小值
                    halve += nh  # x 减半，那么 y 只能不变
            return not_halve, halve
        return min(dfs(0, -1))

# leetcode submit region end(Prohibit modification and deletion)
