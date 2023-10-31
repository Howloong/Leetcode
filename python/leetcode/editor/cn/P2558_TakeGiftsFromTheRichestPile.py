import heapq
import math
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        gifts = list(map(lambda x: -x, gifts))
        heapq.heapify(gifts)

        while k:
            t = -heapq.heappop(gifts)
            heapq.heappush(gifts, -math.floor(math.sqrt(t)))
            k -= 1
        return -sum(gifts)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().pickGifts([25, 64, 9, 4, 100], 4))
print(Solution().pickGifts([1,1,1,1], 4))
