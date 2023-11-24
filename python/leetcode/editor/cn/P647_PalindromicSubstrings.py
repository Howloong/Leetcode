# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSubstrings(self, s: str) -> int:
        def expand(left: int, right: int) -> int:
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return (right - left - 2) // 2

        ans = len(s)
        s = '#' + '#'.join(s) + '#'
        P = []
        c = -1
        y = -1

        for i in range(len(s)):
            if y >= i:
                i_sym = 2 * c - i
                min_arm_len = min(y - i, P[i_sym])
                cur_arm_len = expand(i - min_arm_len, i + min_arm_len)
            else:
                cur_arm_len = expand(i, i)
            P.append(cur_arm_len)
            if i + cur_arm_len > y:
                c = i
                y = c + cur_arm_len
            ans += P[i] // 2
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().countSubstrings("aaa"))
print(Solution().countSubstrings("abcba"))
print(Solution().countSubstrings("abc"))
