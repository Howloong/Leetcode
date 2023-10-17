# leetcode submit region begin(Prohibit modification and deletion)
from collections import Counter


class Solution:
    def balancedString(self, s: str) -> int:
        n = len(s)
        cnt = Counter(s)
        t = (v <= n >> 2 for v in cnt.values())
        if all(v <= n >> 2 for v in cnt.values()):
            return 0
        left = 0
        right = 0
        res = n
        while right < n:
            cnt[s[right]] -= 1
            while left <= right and all(v <= n >> 2 for v in cnt.values()):
                res = min(res, right - left + 1)
                cnt[s[left]] += 1
                left += 1
            right += 1
        return res


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().balancedString("WQWRQQQW"))
print(Solution().balancedString("WWEQERQWQWWRWWERQWEQ"))
print(Solution().balancedString("QWER"))
print(Solution().balancedString("QQWE"))
print(Solution().balancedString("QQQW"))
print(Solution().balancedString("QQQQ"))
