# leetcode submit region begin(Prohibit modification and deletion)
from itertools import pairwise


class Solution:
    def addMinimum(self, word: str) -> int:
        return (1 + sum(x >= y for x, y in pairwise(word))) * 3 -len(word)

    pass


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().addMinimum("aaabcb"))
print(Solution().addMinimum("aaaaac"))
print(Solution().addMinimum("aaa"))
print(Solution().addMinimum("aaabcbc"))

print(Solution().addMinimum("abc"))
