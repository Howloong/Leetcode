from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        h100 = round(hour * 100)
        n = len(dist)
        if h100 <= 100 * (n - 1):
            return -1

        def check(speed: int) -> bool:
            t = 0
            for i in range(n - 1):
                t += (dist[i] - 1) // speed + 1
            t *= speed
            t += dist[-1]
            return 100 * t <= h100 * speed

        left, right = 1, 10 ** 7
        while left <= right:
            mid = (left + right) // 2
            if check(speed=mid):
                right = mid - 1
            else:
                left = mid + 1
        return left


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minSpeedOnTime([1, 1, 100000], 2.01))
print(Solution().minSpeedOnTime([1, 3, 2], 6))
print(Solution().minSpeedOnTime([1, 3, 2], 2.7))
print(Solution().minSpeedOnTime([1, 3, 2], 1.9))
