from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minDeletion(self, nums: List[int]) -> int:
        stack = []
        for num in nums:
            n = len(stack)
            if not n:
                stack.append(num)
            else:
                if (n - 1) % 2 == 0 and stack[-1] == num:
                    continue
                stack.append(num)
        n = len(stack)
        return len(nums) - (n if n % 2 == 0 else n - 1)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minDeletion([1, 1, 2, 2, 3, 3]))
print(Solution().minDeletion([1, 1, 2, 3, 5]))
