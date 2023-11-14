# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    # 求回文半径
    def expand(self, s: str, left: int, right: int) -> int:
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        # 当左右不等或者越界时停止，所以需要减掉2
        return (right - left - 2) // 2

    def longestPalindrome(self, s: str) -> str:
        start, end = 0, -1
        s = '#' + '#'.join(s) + '#'
        # 数组P，存放回文半径
        P = []
        # 记录当前的最右边界
        y = -1
        # 中心点
        c = -1
        # 从i开始向右遍历
        for i in range(len(s)):
            # 如果当前点在最右边界之内
            if y >= i:
                # 拿到i的对称点:i_sym=c-(i-c)=2*c-i
                i_sym = 2 * c - i
                # 是否超过了最远边界,比较i的最远边界（通过对称点获取）和y-i
                min_arm_len = min(P[i_sym], y - i)
                # 从当前位置开始扩展
                cur_arm_len = self.expand(s, i - min_arm_len, i + min_arm_len)
            else:
                # 否则正常扩展
                cur_arm_len = self.expand(s, i, i)
            P.append(cur_arm_len)
            # 更新最远边界
            if i + cur_arm_len > y:
                c = i
                y = c + cur_arm_len
            # 更新结果
            if 2 * cur_arm_len + 1 > end - start:
                start = i - cur_arm_len
                end = i + cur_arm_len
        # 最后start和end一定会落在#上
        return s[start + 1:end + 1:2]


# leetcode submit region end(Prohibit modification and deletion)


print(Solution().longestPalindrome("cbbd"))
