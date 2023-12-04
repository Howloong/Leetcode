from itertools import accumulate
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        nums = [0] * 1001
        for num, _from, _to in trips:
            nums[_from] += num
            nums[_to] -= num
        return all(s <= capacity for s in accumulate(nums))


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().carPooling([[9, 0, 1], [3, 3, 7]], 4))
print(Solution().carPooling([[2, 1, 5], [3, 3, 7]], 4))
print(Solution().carPooling([[2, 1, 5], [3, 3, 7]], 5))
