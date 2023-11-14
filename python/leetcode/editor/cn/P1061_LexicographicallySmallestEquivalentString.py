# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    class UnionFind:
        def __init__(self):
            self.nodes = [i for i in range(26)]

        def find(self, x):
            return x if x == self.nodes[x] else self.find(self.nodes[x])

        def union(self, x, y):
            x = self.find(x)
            y = self.find(y)
            if x == y:
                return
            if x < y:
                self.nodes[y] = x
            else:
                self.nodes[x] = y

    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        u = self.UnionFind()
        n = len(s1)
        for i in range(n):
            t1 = ord(s1[i]) - 97
            t2 = ord(s2[i]) - 97
            u.union(t1, t2)
        res = ""
        for c in baseStr:
            res += chr(u.find(ord(c) - 97) + 97)
        return res

    # leetcode submit region end(Prohibit modification and deletion)


print(Solution().smallestEquivalentString("parker", "morris", "parser"))
