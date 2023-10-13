# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        if num == 0:
            return True
        if num % 10 == 0:
            return False
        return True
# leetcode submit region end(Prohibit modification and deletion)

print(Solution().isSameAfterReversals(526))
print(Solution().isSameAfterReversals(1800))
print(Solution().isSameAfterReversals(0))
