from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        # res = []
        # for num in nums:
        #     t = len(res)
        #     while num:
        #         res.append(num % 10)
        #         num //= 10
        #     res[t:] = res[t:][::-1]
        # return res
        return [d for t in nums for d in map(int, str(t))]

# leetcode submit region end(Prohibit modification and deletion)
