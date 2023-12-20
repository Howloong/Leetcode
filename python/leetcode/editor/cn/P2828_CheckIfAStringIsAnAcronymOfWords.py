from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isAcronym(self, words: List[str], s: str) -> bool:
        return s == ''.join(word[0] for word in words)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().isAcronym(["alice", "bob", "charlie"], "abc"))
