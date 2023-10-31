from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        left, right = 0, len(citations)

        def func(num) -> bool:
            res = False
            for n in citations:
                res += 1 if n >= num else 0
            return num <= res

        while left <= right:
            mid = (left + right) // 2
            if func(mid):
                left = mid + 1
            else:
                right = mid - 1
        return right
# leetcode submit region end(Prohibit modification and deletion)
