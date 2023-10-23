from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        n = len(satisfaction)
        satisfaction.sort()
        i = n
        res = 0
        tmp = 0
        while i > 0:
            if res + tmp + satisfaction[i - 1] < res:
                return res
            res = res + tmp + satisfaction[i - 1]
            tmp += satisfaction[i - 1]
            i -= 1
        return res
    # leetcode submit region end(Prohibit modification and deletion)


print(Solution().maxSatisfaction([-1, -8, 0, 5, -9]))
print(Solution().maxSatisfaction([4, 3, 2]))
print(Solution().maxSatisfaction([-1, -4, -5]))
