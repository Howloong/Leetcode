# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        l = []
        remain = len(num) - k
        for i in num:
            while k and l and l[-1] > i:
                l.pop()
                k -= 1
            l.append(i)
        return ''.join(l[:remain]).lstrip('0') or '0'


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().removeKdigits("9", 1))
