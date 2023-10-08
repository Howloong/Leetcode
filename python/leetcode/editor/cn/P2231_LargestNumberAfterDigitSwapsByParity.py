# leetcode submit region begin(Prohibit modification and deletion)
from heapq import heappush, heappop


class Solution:
    def largestInteger(self, num: int) -> int:
        m1 = []
        m2 = []
        num = str(num)
        for n in num:
            x = int(n)
            heappush(m1 if x % 2 == 0 else m2, -x)
        res = ""
        for n in num:
            x = int(n)
            res += str(-heappop(m1 if x % 2 == 0 else m2))
        return int(res)


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.largestInteger(1234))
print(s.largestInteger(65875))
