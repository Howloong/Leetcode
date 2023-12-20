from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def secondGreaterElement(self, nums: List[int]) -> List[int]:
        _stack = []
        n = len(nums)
        t = [-1] * n
        temp = []
        for i, num in enumerate(nums):
            while temp and nums[temp[-1]] < num:
                t[temp[-1]] = num
                temp.pop()
            j = len(_stack) - 1
            while j >= 0 and nums[_stack[j]] < num:
                j -= 1
            temp += _stack[j + 1:]
            del _stack[j + 1:]
            _stack.append(i)
        return t

    # leetcode submit region end(Prohibit modification and deletion)


print(Solution().secondGreaterElement([2, 4, 0, 9, 6]))
print(Solution().secondGreaterElement([11, 13, 15, 12, 0, 15, 12, 11, 9]) == [15, 15, -1, -1, 12, -1, -1, -1, -1])
print(Solution().secondGreaterElement([1, 17, 18, 0, 18, 10, 20, 0]))
# print(Solution().secondGreaterElement([3,3]))
