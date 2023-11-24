from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        _dict = defaultdict()
        res = -1

        def getSum(n: int) -> int:
            t = 0
            while n:
                t += n % 10
                n //= 10
            return t

        for num in nums:
            t = getSum(num)
            if t in _dict:
                res = max(res, num + _dict.get(t))
                _dict[t] = max(num, _dict[t])
            else:
                _dict[t] = num
        return res


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maximumSum([10, 12, 19, 14]))
print(Solution().maximumSum([18, 43, 36, 13, 7]))
