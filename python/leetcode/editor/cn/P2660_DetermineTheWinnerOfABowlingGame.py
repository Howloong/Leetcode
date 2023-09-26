# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def isWinner(self, player1, player2):
        """
        :type player1: List[int]
        :type player2: List[int]
        :rtype: int
        """
        sum1 = 0
        sum2 = 0
        n = len(player1)
        for i in range(n):
            n1 = player1[i]
            n2 = player2[i]
            v1 = i - 2 >= 0 and player1[i - 2] == 10
            v2 = i - 1 >= 0 and player1[i - 1] == 10
            if v1 or v2:
                sum1 += n1 * 2
            else:
                sum1 += n1
            v1 = i - 2 >= 0 and player2[i - 2] == 10
            v2 = i - 1 >= 0 and player2[i - 1] == 10
            if v1 or v2:
                sum2 += n2 * 2
            else:
                sum2 += n2
        if sum1 == sum2:
            return 0
        if sum1 > sum2:
            return 1
        return 2


# leetcode submit region end(Prohibit modification and deletion)

s = Solution
# print(s.isWinner(s, [4, 10, 7, 9], [6, 5, 2, 3]))
# print(s.isWinner(s, [5,6,1,10], [5,1,10,5]))
print(s.isWinner(s, [10,4,0,2], [5,10,8,0]))
# print(s.isWinner(s, [2, 3], [4, 1]))
# print(s.isWinner(s, [3, 6, 10, 8], [9, 9, 9, 9]))
