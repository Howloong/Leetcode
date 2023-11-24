# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        def extends(left: int, right: int) -> int:
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return (right - left - 2) // 2

        tmp = s
        start, end = 0, -1
        s = '#' + '#'.join(s) + "#"
        # 回文半径
        P = []
        # 右边界
        y = -1
        # 中心点
        c = -1
        for i in range(len(s)):
            if y >= i:
                i_sym = 2 * c - i
                min_arm_len = min(P[i_sym], y - i)
                cur_arm_len = extends(i - min_arm_len, i + min_arm_len)
            else:
                cur_arm_len = extends(i, i)
            P.append(cur_arm_len)
            if i + cur_arm_len > y:
                c = i
                y = c + cur_arm_len
            if 2 * cur_arm_len + 1 > end - start:
                start = i - cur_arm_len
                end = i + cur_arm_len
        k = 0
        for i in range(len(s)):
            if P[i] == i:
                k = i
        return s[k * 2+1::2][::-1] + tmp


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().shortestPalindrome("aacecaaa"))
print(Solution().shortestPalindrome("a"))
print(Solution().shortestPalindrome("abcd"))
print(Solution().shortestPalindrome("baacecaaa"))
