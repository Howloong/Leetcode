import heapq
from collections import Counter
from heapq import heappush
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        c = Counter(nums)
        m = []
        for num, count in c.items():
            heappush(m, (count, num))
        return [t for _, t in heapq.nlargest(k, m)]


# leetcode submit region end(Prohibit modification and deletion)
