from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numOfBurgers(self, tomatoSlices: int, cheeseSlices: int) -> List[int]:
        x = tomatoSlices - 2 * cheeseSlices
        y = 4 * cheeseSlices - tomatoSlices
        return [x // 2, y // 2] if x % 2 == 0 and y % 2 == 0 and x >= 0 and y >= 0 else []
# leetcode submit region end(Prohibit modification and deletion)
