from typing import List


# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        ans = mask = 0
        high_bit = max(nums).bit_length() - 1
        for i in range(high_bit, -1, -1):
            mask |= 1 << i
            new_ans = ans | (1 << i)
            seen = set()
            for x in nums:
                x &= mask
                if new_ans ^ x in seen:
                    ans = new_ans
                    break
                seen.add(x)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().findMaximumXOR([3, 10, 5, 25, 2, 8]))
