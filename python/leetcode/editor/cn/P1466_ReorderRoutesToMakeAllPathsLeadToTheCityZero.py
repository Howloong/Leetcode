from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        g: List[List[tuple]] = [[] for _ in range(n)]
        for a, b, in connections:
            g[a].append((b, 1))
            g[b].append((a, 0))

        # def dfs(a: int, fa: int) -> int:
        #     t = 0
        #     for b, c in g[a]:
        #         if b != fa:
        #             t += c + dfs(b, a)
        #     return t

        _l = [0]
        isVisited = [False] * n
        ans = 0
        while _l:
            t = _l.pop()
            isVisited[t] = True
            for b, c in g[t]:
                if not isVisited[b]:
                    _l.append(b)
                    ans += c

        return ans
    # leetcode submit region end(Prohibit modification and deletion)


print(Solution().minReorder(6, [[0, 1], [1, 3], [2, 3], [4, 0], [4, 5]]))
