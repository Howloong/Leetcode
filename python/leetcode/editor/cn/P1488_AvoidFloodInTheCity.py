from typing import List

# leetcode submit region begin(Prohibit modification and deletion)
from sortedcontainers import SortedList


class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        n = len(rains)
        ans = [1] * n
        sunny = SortedList()
        rainy = {}
        for i, rain in enumerate(rains):
            if rain:
                ans[i] = -1
                if rain in rainy:
                    it = sunny.bisect(rainy[rain])
                    if it == len(sunny):
                        return []
                    ans[sunny[it]] = rain
                    sunny.discard(sunny[it])
                rainy[rain] = i
            else:
                sunny.add(i)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
# print(Solution().avoidFlood([1, 2, 3, 4]))
print(Solution().avoidFlood([1, 2, 0, 0, 2, 1]))
