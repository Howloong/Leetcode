from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        d = []
        for num in nums:
            if not d or num > d[-1]:
                d.append(num)
            else:
                left, right = 0, len(d) - 1
                while left <= right:
                    mid = (left + right) // 2
                    if d[mid] >= num:
                        right = mid - 1
                    else:
                        left = mid + 1
                d[left] = num
        return len(d)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().lengthOfLIS([0, 8, 4, 12, 2]))
