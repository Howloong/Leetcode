# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countPoints(self, rings: str) -> int:
        n = len(rings)
        res = [set() for _ in range(10)]
        for i in range(0, n, 2):
            color = rings[i]
            t = rings[i + 1]
            res[int(t)].add(color)
        return sum(1 for t in res if len(t) == 3)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().countPoints("B0B6G0R6R0R6G9"))
print(Solution().countPoints("G4"))
