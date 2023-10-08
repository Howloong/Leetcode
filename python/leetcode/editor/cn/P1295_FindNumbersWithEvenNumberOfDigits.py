from typing import List

# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        return len([res for res in nums if len(str(res)) % 2 == 0])


# leetcode submit region end(Prohibit modification and deletion)
s=Solution()
print(s.findNumbers([12,345,2,6,7896]))