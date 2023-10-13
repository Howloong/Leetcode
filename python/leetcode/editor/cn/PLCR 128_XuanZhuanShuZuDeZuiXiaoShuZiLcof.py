from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def stockManagement(self, stock: List[int]) -> int:
        left = 0
        right = len(stock) - 2
        while left <= right:
            mid = left + (right - left) // 2
            if stock[mid] < stock[right + 1]:
                right = mid - 1
            elif stock[mid] > stock[right + 1]:
                left = mid + 1
            else:
                right -= 1
        return stock[left]
# leetcode submit region end(Prohibit modification and deletion)
