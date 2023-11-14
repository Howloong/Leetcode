from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        n = len(potions)
        _dict = {}
        ans = []

        for spell in spells:
            left, right = 0, n - 1
            if spell in _dict:
                ans.append(_dict[spell])
            else:
                while left <= right:
                    mid = (left + right) >> 1
                    if potions[mid] * spell >= success:
                        right = mid - 1
                    else:
                        left = mid + 1
                ans.append(n - left)
                _dict[spell] = n - left
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().successfulPairs([5, 1, 3], [1, 2, 3, 4, 5], 7))
