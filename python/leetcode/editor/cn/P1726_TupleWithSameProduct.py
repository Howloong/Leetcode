from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        n = len(nums)
        cnt = Counter([nums[i]*nums[j] for i in range(n) for j in range(i + 1, n)])
        res = 0
        for _, v in cnt.items():
            res += ((v * (v - 1)) <<2)
        return res


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().tupleSameProduct([2, 3, 4, 6]))
