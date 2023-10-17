from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        xor = 0
        for num in nums:
            xor ^= num
        mask = xor & (-xor)
        type1 = type2 = 0
        for num in nums:
            if num & mask:
                type1 ^= num
            else:
                type2 ^= num
        return [type2, type1]


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().singleNumber([1, 2, 1, 3, 2, 5]))
