# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def splitNum(self, num: int) -> int:
        strnum = "".join(sorted(str(num)))
        return int(strnum[:: 2]) + int(strnum[1:: 2])


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.splitNum(100001))
print(s.splitNum(10))
print(s.splitNum(4325))
print(s.splitNum(687))
