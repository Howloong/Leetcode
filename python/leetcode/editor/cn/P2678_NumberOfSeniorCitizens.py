from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSeniors(self, details: List[str]) -> int:
        return sum(1 for detail in details if int(detail[-4:-2]) > 60)

    # leetcode submit region end(Prohibit modification and deletion)


print(Solution().countSeniors(["7868190130M7522", "5303914400F9211", "9273338290F4010"]))
print(Solution().countSeniors(["1313579440F2036", "2921522980M5644"]))
