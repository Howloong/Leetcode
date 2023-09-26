# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        i = 0
        j = len(numbers) - 1
        while i != j:
            t = numbers[i] + numbers[j]
            if t == target:
                return [i+1, j+1]
            if t > target:
                j -= 1
            elif t < target:
                i += 1
        return -1

# leetcode submit region end(Prohibit modification and deletion)

s = Solution
print(s.twoSum(s, [2, 7, 11, 15], 9))
print(s.twoSum(s, [2, 3, 4], 6))
