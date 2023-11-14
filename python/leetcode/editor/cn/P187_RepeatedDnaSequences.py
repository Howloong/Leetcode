from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        N = 10 ** 5 + 1
        P = 131
        ans = []
        n = len(s)
        h = [0] * N
        p = [0] * N
        p[0] = 1
        _map = {'A': 1, 'C': 2, 'G': 3, 'T': 4}
        MOD = 10**9+7
        for i in range(1, n + 1):
            h[i] = (((h[i - 1] * P + _map.get(s[i-1])) % MOD) + MOD) % MOD
            p[i] = (p[i - 1] * P)%MOD
        dict = {}
        i = 1
        while i + 10 - 1 <= n:
            j = i + 9
            hash = (((h[j] - h[i - 1] * p[j - i + 1]) % MOD) + MOD) % MOD
            cnt = dict.get(hash, 0)
            if cnt == 1:
                ans.append(s[i - 1: i - 1 + 10])
            dict[hash] = cnt + 1
            i += 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))
print(Solution().findRepeatedDnaSequences("AAAAAAAAAAAAA"))
