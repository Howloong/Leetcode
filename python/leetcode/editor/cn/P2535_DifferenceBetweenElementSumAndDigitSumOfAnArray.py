from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def differenceOfSum(self, nums: List[int]) -> int:
        def getSum(num):
            s = 0
            while num:
                s += num % 10
                num //= 10
            return s
        t1 = 0
        t2 = 0
        for num in nums:
            t1 += getSum(num)
            t2 += num
        return t2-t1
# leetcode submit region end(Prohibit modification and deletion)
