# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        round = int(time / (n - 1))
        if round % 2 == 1:
            return n - time % (n - 1)
        return time % (n - 1) + 1


# leetcode submit region end(Prohibit modification and deletion)


s = Solution
print(s.passThePillow(s, 4, 5))
print(s.passThePillow(s, 3, 2))
print(s.passThePillow(s, 20, 9))
print(s.passThePillow(s, 9, 4))
