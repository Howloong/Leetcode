from typing import Counter


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        c1: dict = Counter(ransomNote)
        c2: dict = Counter(magazine)
        for k, v in c1.items():
            if k not in c2 or v > c2[k]:
                return False
        return True


# leetcode submit region end(Prohibit modification and deletion)
# print(Solution().canConstruct("a", "b"))
print(Solution().canConstruct("aa", "ab"))
print(Solution().canConstruct("aa", "aab"))
