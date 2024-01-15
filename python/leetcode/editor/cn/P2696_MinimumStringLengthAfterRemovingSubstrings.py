# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minLength(self, s: str) -> int:
        _stack = []
        for c in s:
            if len(_stack) < 1:
                _stack.append(c)
            else:
                t = _stack[-1] + str(c)
                if t == "AB" or t == "CD":
                    _stack.pop()
                else:
                    _stack.append(c)
        return len(_stack)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minLength("ABFCACDB"))
print(Solution().minLength("ACBBD"))
