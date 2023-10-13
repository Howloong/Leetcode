from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        res = ['']* len(s)
        for i in range(len(s)):
            res[indices[i]] = s[i]
        return ''.join(res)
# leetcode submit region end(Prohibit modification and deletion)
print(Solution().restoreString("codeleet",[4,5,6,7,0,2,1,3]))