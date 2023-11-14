# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0

        n = len(haystack)
        m = len(needle)
        # 添加哨兵，下标均从1开始
        haystack = " " + haystack
        needle = " " + needle
        # 构建next数组
        next = [0] * (m + 1)
        # i从2开始，j从0开始，这样就需要比较j+1和i的值，同时j=next[j]
        # 或者j从1开始，需要比较i和j的值，j=next[j-1]
        i, j = 2, 0
        while i <= m:
            # 匹配不成功，j=next[j]
            while j > 0 and needle[i] != needle[j + 1]:
                j = next[j]
            # 匹配成功，j先加1
            if needle[i] == needle[j + 1]:
                j += 1
            next[i] = j
            i += 1
        # 匹配
        i, j = 1, 0
        while i <= n:
            # 如果匹配不成功，则j=next[j]，找到最长的前后缀
            while j > 0 and haystack[i] != needle[j + 1]:
                j = next[j]
            # 匹配成功，则先让j++
            if haystack[i] == needle[j + 1]:
                j += 1
            # 匹配成功，返回下标
            if j == m:
                return i - m
            i += 1
        return -1

# leetcode submit region end(Prohibit modification and deletion)
print(Solution().strStr("sadbutsad", "abtabsabtabt"))
print(Solution().strStr("leetcode", "leeto"))
