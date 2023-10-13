from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        res = [0] * n
        stack = []
        for i in range(n):
            t = temperatures[i]
            while len(stack) and t > temperatures[stack[-1]]:
                p = stack.pop()
                res[p] = i - p
            stack.append(i)
        return res
# leetcode submit region end(Prohibit modification and deletion)
print(Solution().dailyTemperatures([73,74,75,71,69,72,76,73]))