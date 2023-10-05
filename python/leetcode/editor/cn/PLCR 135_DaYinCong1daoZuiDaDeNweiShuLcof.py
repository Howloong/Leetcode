from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countNumbers(self, cnt: int) -> List[int]:
        return [num for num in range(1, pow(10, cnt))]


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().countNumbers(5))
