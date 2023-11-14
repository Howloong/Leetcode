from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def vowelStrings(self, words: List[str], left: int, right: int) -> int:
        s = {'a', 'e', 'i', 'o', 'u'}
        return sum(1 for i in range(left,right+1) if words[i][0] in s and words[i][-1] in s)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().vowelStrings(["are", "amy", "u"], 0, 2))
