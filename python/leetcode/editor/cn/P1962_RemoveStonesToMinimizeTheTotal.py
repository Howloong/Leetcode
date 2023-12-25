import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        piles = list(map(lambda x: -x, piles))
        heapq.heapify(piles)
        for i in range(k):
            t = -heapq.heappop(piles)
            t = t - t // 2
            heapq.heappush(piles, -t)
        return -sum(piles)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minStoneSum([4, 3, 6, 7], 3))
print(Solution().minStoneSum([1], 100000))
print(Solution().minStoneSum([5, 4, 9], 2))
