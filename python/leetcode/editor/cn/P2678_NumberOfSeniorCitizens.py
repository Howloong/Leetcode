from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSeniors(self, details: List[str]) -> int:
        return sum(1 for detail in details if int(detail[-4:-2]) > 60)

# leetcode submit region end(Prohibit modification and deletion)
