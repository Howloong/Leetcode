import sys
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        n = len(s)
        d = [sys.maxsize] * (n + 1)
        d[0] = 0
        _map = set(dictionary)
        for i in range(1, n + 1):
            d[i] = d[i - 1] + 1
            for j in range(i):
                if s[j:i] in _map:
                    d[i] = min(d[i], d[j])
        return d[n]
# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minExtraChar("leetscode",["leet","code","leetcode"]))
print(Solution().minExtraChar("sayhelloworld",["hello","world"]))