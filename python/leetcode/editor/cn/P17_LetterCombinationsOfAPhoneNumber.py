from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        MAPPING = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        n = len(digits)
        if not n:
            return []
        ans = []
        path = [''] * n

        def dfs(i):
            if i == n:
                ans.append(''.join(path))
                return
            for c in MAPPING[int(digits[i])]:
                path[i] = c
                dfs(i + 1)

        dfs(0)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().letterCombinations("23"))
