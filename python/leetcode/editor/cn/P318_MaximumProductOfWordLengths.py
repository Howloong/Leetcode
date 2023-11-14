from functools import reduce
from itertools import product
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxProduct(self, words: List[str]) -> int:
        mask = [reduce(lambda x, y: x | (1 << ord(y) - ord('a')), word, 0) for word in words]
        return max((len(x[1]) * len(y[1]) for x, y in product(zip(mask, words), repeat=2) if x[0] & y[0] == 0), default=0)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maxProduct(["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]))
