# leetcode submit region begin(Prohibit modification and deletion)
from collections import Counter


class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        if len(word1) != len(word2):
            return False

        c1, c2 = Counter(word1), Counter(word2)
        return c1.keys() == c2.keys() and Counter(c1.values()) == Counter(c2.values())

    # leetcode submit region end(Prohibit modification and deletion)


print(Solution().closeStrings("uua", "ssx"))
print(Solution().closeStrings("abbzccca", "babzzczc"))
print(Solution().closeStrings("abc", "bca"))
print(Solution().closeStrings("a", "aaa"))
print(Solution().closeStrings("cabbba", "abbccc"))
print(Solution().closeStrings("cabbba", "aabbss"))
