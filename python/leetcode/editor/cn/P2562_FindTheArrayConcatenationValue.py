from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findTheArrayConcVal(self, nums: List[int]) -> int:
        def add(num1: int, num2: int):
            return int(str(num1) + str(num2))

        i = 0
        j = len(nums) - 1
        res = 0
        while i < j:
            res += add(nums[i], nums[j])
            i += 1
            j -= 1
        return res + nums[i] if i == j else res

# leetcode submit region end(Prohibit modification and deletion)
print(Solution().findTheArrayConcVal([7,52,2,4]))
print(Solution().findTheArrayConcVal([5,14,13,8,12]))