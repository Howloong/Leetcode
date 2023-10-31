from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        ans = []
        path = []
        n = len(s)

        def dfs(i: int):
            if i == n:
                ans.append(''.join(path))
                return
            if s[i].isalpha():
                path.append(s[i])
                dfs(i + 1)
                path.pop()
                path.append(s[i].upper() if s[i].islower() else s[i].lower())
                dfs(i + 1)
                path.pop()
            else:
                path.append(s[i])
                dfs(i + 1)
                path.pop()

        dfs(0)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
# print(Solution().letterCasePermutation("a1b2"))
# print(Solution().letterCasePermutation("3z4"))
print(Solution().letterCasePermutation("C"))
