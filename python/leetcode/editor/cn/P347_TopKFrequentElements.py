# leetcode submit region begin(Prohibit modification and deletion)
import heapq
from collections import Counter
from heapq import heappush
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        c = Counter(nums)
        m = []
        for num, count in c.items():
            heappush(m, (count,num))
        return [t for _,t in heapq.nlargest(k, m)]


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.topKFrequent([1, 1, 1, 2, 2, 3], 2))
print(s.topKFrequent([-1, -1], 1))
