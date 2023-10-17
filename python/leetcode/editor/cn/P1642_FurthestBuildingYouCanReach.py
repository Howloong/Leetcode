# leetcode submit region begin(Prohibit modification and deletion)
import heapq
from typing import List


class Solution:
    # 二分
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        def canAchieve(index: int) -> bool:
            deltas = []
            t = bricks
            for i in range(index):
                if heights[i] < heights[i + 1]:
                    heapq.heappush(deltas, -(heights[i + 1] - heights[i]))
            for i in range(ladders):
                if deltas:
                    heapq.heappop(deltas)
            for i in deltas:
                t += i
                if t < 0:
                    return False
            return True

        left, right = 0, len(heights) - 1
        while left <= right:
            mid = (left + right) // 2
            if canAchieve(mid):
                left = mid + 1
            else:
                right = mid - 1
        return right

    # 贪心
    def furthestBuilding2(self, heights: List[int], bricks: int, ladders: int) -> int:
        n = len(heights)
        pq = []
        for i in range(n - 1):
            if heights[i] < heights[i + 1]:
                heapq.heappush(pq, (heights[i + 1] - heights[i]))
                if len(pq) > ladders:
                    bricks -= heapq.heappop(pq)
                    if bricks < 0:
                        return i
        return n - 1


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().furthestBuilding2([4, 2, 7, 6, 9, 14, 12], 5, 1) == 4)
print(Solution().furthestBuilding([4, 12, 2, 7, 3, 18, 20, 3, 19], 10, 2) == 7)
print(Solution().furthestBuilding([14, 3, 19, 3], 17, 0) == 3)
print(Solution().furthestBuilding([1, 5, 1, 2, 3, 4, 10000], 4, 1) == 5)
