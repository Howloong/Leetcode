import datetime
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def dayOfTheWeek(self, day: int, month: int, year: int) -> str:
        return ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"][
            datetime.datetime.strptime(str(year) + str("{:0>2d}".format(month)) + str("{:0>2d}".format(day)),
                                       "%Y%m%d").weekday()]
# leetcode submit region end(Prohibit modification and deletion)
