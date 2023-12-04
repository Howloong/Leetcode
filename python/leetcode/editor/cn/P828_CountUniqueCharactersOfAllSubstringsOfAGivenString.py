# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def uniqueLetterString(self, s: str) -> int:
        n = len(s)
        ans = 0
        l = [0] * n
        r = [0] * n
        idx = [-1] * 26
        for i, c in enumerate(map(lambda x: ord(x) - ord('A'), s)):
            l[i] = idx[c]
            idx[c] = i
        idx = [n] * 26
        for i, c in reversed(list(enumerate(map(lambda x: ord(x) - ord('A'), s)))):
            r[i] = idx[c]
            idx[c] = i
        for i in range(n):
            ans += (i - l[i]) * (r[i] - i)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().uniqueLetterString("ABC"))
