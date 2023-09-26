# leetcode submit region begin(Prohibit modification and deletion)
from collections import Counter


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        ans = 0
        cnt = set()
        left = 0
        for right, c in enumerate(s):
            while c in cnt:
                cnt.remove(s[left])
                left += 1
            cnt.add(c)
            ans = max(ans, right - left + 1)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
s = Solution
print(s.lengthOfLongestSubstring(s, "abcabcbb"))
