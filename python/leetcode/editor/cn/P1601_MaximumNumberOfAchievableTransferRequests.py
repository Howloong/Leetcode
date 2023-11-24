from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumRequests(self, n: int, requests: List[List[int]]) -> int:
        ans = 0
        req = [0] * n
        zero = n

        def check() -> bool:
            for r in req:
                if r != 0:
                    return False
            return True

        def dfs(idx: int, num: int):
            nonlocal ans, zero
            if idx == len(requests):
                if zero == n:
                    ans = max(ans, num)
                return
            dfs(idx + 1, num)
            t = zero
            _from = requests[idx][0]
            _to = requests[idx][1]
            req[_from] -= 1
            req[_to] += 1
            zero -= req[_from] != 0
            zero -= req[_to] != 0
            dfs(idx + 1, num + 1)
            req[_from] += 1
            req[_to] -= 1
            zero = t

        dfs(0, 0)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maximumRequests(5, [[0, 1], [1, 0], [0, 1], [1, 2], [2, 0], [3, 4]]))
print(Solution().maximumRequests(3, [[0, 0], [1, 2], [2, 1]]))
print(Solution().maximumRequests(4, [[0, 3], [3, 1], [1, 2], [2, 0]]))
