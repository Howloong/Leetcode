from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxTaxiEarnings(self, n: int, rides: List[List[int]]) -> int:
        dp = [0] * (len(rides) + 1)
        rides.sort(key=lambda x: x[1])
        for idx, (start, end, tip), in enumerate(rides, 1):
            left, right = 0, idx
            while left <= right:
                mid = (left + right) // 2
                if rides[mid][1] > start:
                    right = mid - 1
                else:
                    left = mid + 1
            dp[idx] = max(dp[idx - 1], dp[left] + end - start + tip)
        return dp[-1]


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maxTaxiEarnings(10, [[2, 3, 6], [8, 9, 8], [5, 9, 7], [8, 9, 1], [2, 9, 2], [9, 10, 6], [7, 10, 10],
                                      [6, 7, 9], [4, 9, 7], [2, 3, 1]]) == 33)
print(Solution().maxTaxiEarnings(20, [[1, 6, 1], [3, 10, 2], [10, 12, 3], [11, 12, 2], [12, 15, 2], [13, 18, 1]]))
print(Solution().maxTaxiEarnings(5, [[2, 5, 4], [1, 5, 1]]))
