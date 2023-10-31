from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans = []
        path = []
        n = len(s)

        def dfs(i: int, start: int):
            if n == i:
                ans.append(path.copy())
                return
            if i < n - 1:
                dfs(i + 1, start)
            t = s[start:i+1]
            if t == t[::-1]:
                path.append(t)
                dfs(i + 1, i + 1)
                path.pop()

        dfs(0, 0)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().partition("aab"))
