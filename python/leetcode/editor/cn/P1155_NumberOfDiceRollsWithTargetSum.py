# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    # def numRollsToTarget(self, n: int, k: int, target: int) -> int:
    #     MOD = 10 ** 9 + 7
    #     if not (n <= target <= n * k):
    #         return 0

    #         @cache
    #         def recursion(i: int, j: int) -> int:
    #             if i == 0:
    #                 return int(j == 0)
    #             res = 0
    #             for n in range(min(k, j + 1)):
    #                 res += recursion(i - 1, j - n)
    #             return res % MOD

    #         return recursion(n, target-n)
    # def numRollsToTarget(self, n: int, k: int, target: int) -> int:
    #     MOD = 10 ** 9 + 7
    #     if not (n <= target <= n * k):
    #         return 0
    #     dp = [[0] * (target - n + 1) for _ in range(n + 1)]
    #     dp[0][0] = 1
    #     for i in range(1, n + 1):
    #         for j in range(target - n + 1):
    #             for x in range(min(k, j + 1)):
    #                 dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % MOD
    #     return dp[n][-1]
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        MOD = 10 ** 9 + 7
        if not (n <= target <= n * k):
            return 0
        dp = [1] + [0] * (target - n)
        for i in range(1, n + 1):
            max_j = min(i * (k - 1), target - n)
            for j in range(1, max_j + 1):
                dp[j] += dp[j - 1]
            for j in range(max_j, k - 1, -1):
                dp[j] = (dp[j] - dp[j - k]) % MOD
        return dp[-1]


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().numRollsToTarget(30, 30, 500))
