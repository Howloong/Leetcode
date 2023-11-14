# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findTheLongestBalancedSubstring(self, s: str) -> int:
        ans = 0
        count = [0, 0]
        n = len(s)
        for i in range(n):
            if s[i] == '1':
                count[1] += 1
                ans = max(ans, min(count) * 2)
            elif i == 0 or s[i-1]=='1':
                count[0] = 1
                count[1] = 0
            else:
                count[0] += 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().findTheLongestBalancedSubstring("000111"))
print(Solution().findTheLongestBalancedSubstring("101"))
print(Solution().findTheLongestBalancedSubstring("0"))
print(Solution().findTheLongestBalancedSubstring("001"))
print(Solution().findTheLongestBalancedSubstring("00111"))
print(Solution().findTheLongestBalancedSubstring("111"))
print(Solution().findTheLongestBalancedSubstring("01000111"))
