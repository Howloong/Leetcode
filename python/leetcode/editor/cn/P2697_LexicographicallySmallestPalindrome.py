# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def makeSmallestPalindrome(self, s: str) -> str:
        i, j = 0, len(s) - 1
        t = [''] * len(s)
        while i <= j:
            if s[i] != s[j]:
                if s[i] < s[j]:
                    t[j] = s[i]
                    t[i] = s[i]
                else:
                    t[i] = s[j]
                    t[j] = s[j]
            else:
                t[i] = t[j] = s[i]
            i += 1
            j -= 1
        return ''.join(t)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().makeSmallestPalindrome("egcfe"))
print(Solution().makeSmallestPalindrome("abcd"))
