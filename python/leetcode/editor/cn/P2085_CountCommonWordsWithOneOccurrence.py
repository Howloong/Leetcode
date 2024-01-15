from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countWords(self, words1: List[str], words2: List[str]) -> int:
        c = Counter(words1)
        t = Counter(words2)
        return sum(1 for k, v in c.items() if v == 1 and k in t and t[k] == 1)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().countWords(words1=["leetcode", "is", "amazing", "as", "is"], words2=["amazing", "leetcode", "is"]))
