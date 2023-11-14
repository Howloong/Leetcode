from collections import deque
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumInvitations(self, favorite: List[int]) -> int:
        n = len(favorite)
        deg = [0] * n
        for i in favorite:
            # 统计每个节点的入度
            deg[i] += 1
        # rg = [[] for _ in range(n)]
        max_depth = [1] * n
        q = deque(i for i, d in enumerate(deg) if d == 0)
        while q:
            x = q.popleft()
            y = favorite[x]
            # 只有一条出边
            # rg[y].append(x)
            max_depth[y] = max_depth[x] + 1
            # 计算最长的链
            deg[y] -= 1

            if deg[y] == 0:
                q.append(y)

        # def rdfs(x: int) -> int:
        #     max_depth = 1
        #     for son in rg[x]:
        #         max_depth = max(max_depth, rdfs(son) + 1)
        #     return max_depth

        max_ring_size = sum_chain_size = 0
        for i, d in enumerate(deg):
            if d == 0:
                continue
            deg[i] = 0
            ring_size = 1
            x = favorite[i]
            while x != i:
                deg[x] = 0
                ring_size += 1
                x = favorite[x]
            if ring_size == 2:
                sum_chain_size += max_depth[i]+max_depth[favorite[i]]
            else:
                max_ring_size = max(max_ring_size, ring_size)
        return max(max_ring_size, sum_chain_size)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maximumInvitations([2, 2, 1, 2]))
print(Solution().maximumInvitations([1, 2, 0]))
print(Solution().maximumInvitations([3, 0, 1, 4, 1]))
