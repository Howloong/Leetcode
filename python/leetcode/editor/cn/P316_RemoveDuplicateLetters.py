from collections import Counter


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        c = Counter(s)
        res = []
        for chs in s:
            if chs not in res:
                while res and chs < res[-1] and c[res[-1]] > 0:
                    res.pop()
                res.append(chs)
            c[chs] -= 1
        return ''.join(res)

# leetcode submit region end(Prohibit modification and deletion)
