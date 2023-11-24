from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        m = n - k + 1
        _sum = [0] * m
        curSum = 0
        for i in range(k):
            curSum += nums[i]
        _sum[0] = curSum
        for i in range(k, n):
            curSum += nums[i]
            curSum -= nums[i - k]
            _sum[i - k + 1] = curSum
        left = [0] * m
        right = [0] * m
        maxIdx = 0
        for i in range(m):
            if _sum[i] > _sum[maxIdx]:
                maxIdx = i
            left[i] = maxIdx
        maxIdx = m - 1
        for i in range(m - 1, -1, -1):
            if _sum[i] >= _sum[maxIdx]:
                maxIdx = i
            right[i] = maxIdx
        maxSum = 0
        for i in range(k, m - k):
            cur = _sum[i] + _sum[left[i - k]] + _sum[right[i + k]]
            if cur > maxSum:
                maxSum = cur
                maxIdx = i
        return [left[maxIdx - k], maxIdx, right[maxIdx + k]]

    # leetcode submit region end(Prohibit modification and deletion)


print(Solution().maxSumOfThreeSubarrays([1, 2, 1, 2, 6, 7, 5, 1], 2) == [0, 3, 5])
print(Solution().maxSumOfThreeSubarrays(
    [62368, 43415, 6411, 30431, 47476, 43988, 57619, 4131, 15320, 8470, 12424, 32500, 37914, 256, 54892, 64542, 44556,
     63623, 32488, 38391, 21821, 814, 17407, 25008, 5503, 20233, 44981, 21616, 17906, 34260, 33045, 6535, 64008, 53390,
     1376, 44651, 16181, 18292, 50643, 15050, 45411, 5124, 30452, 9018, 31760, 7046, 39294, 51894, 43549, 15092, 42683,
     31095, 982, 40803, 44869, 30685, 58595, 54124, 5746, 49021, 37208, 45952, 34455, 1884, 19642, 63556, 21510, 17701,
     25556, 52905, 29963, 2716, 17966, 22775, 56535, 15474, 11496, 15975, 34816, 14486, 53517, 55132, 2444, 7493, 50678,
     40509, 20774, 35932, 9936, 12255, 54904, 3246, 60422, 39236, 21118, 10657, 50107, 53038, 4168, 53669, 26736, 40270,
     45504, 35101, 1857, 34941, 63136, 30522, 52761, 36214, 41522, 51187, 25016, 62798, 55606, 17470, 12428, 49736,
     53277, 37848, 45604, 21964, 58413, 54931, 38205, 19175, 51970, 9769, 4683, 50149, 23165, 15010, 6584, 55412, 59918,
     53641, 64475, 18216, 47808, 21116, 29770, 9262, 31961, 24894, 20219, 16035, 60933, 19904, 15193, 33039, 12544,
     14650, 29748, 22824, 6541, 48083, 3027, 30777, 55442, 33284, 54358, 17329, 10445, 30616, 16699, 10617, 41450,
     52177, 60769, 30161, 31747, 1537, 8882, 26213, 380, 58124, 16460, 37154, 45252, 65258, 8795, 36606, 35192, 34215,
     21100, 39898, 17820, 16225, 31017, 23330, 19812, 14809, 56587, 50279, 46723, 25526, 57230, 15351, 10101, 55003],
    40) == [26, 99, 157])
print(Solution().maxSumOfThreeSubarrays([1, 2, 1, 2, 1, 2, 1, 2, 1], 2) == [0, 2, 4])
print(Solution().maxSumOfThreeSubarrays([4, 5, 10, 6, 11, 17, 4, 11, 1, 3], 1) == [4, 5, 7])
print(Solution().maxSumOfThreeSubarrays([7, 13, 20, 19, 19, 2, 10, 1, 1, 19], 3) == [1, 4, 7])
