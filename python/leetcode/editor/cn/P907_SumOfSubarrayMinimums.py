from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        MOD = 10 ** 9 + 7
        ans = 0
        n = len(arr)
        stack = []
        l = [0] * n
        r = [0] * n
        for idx, num in enumerate(arr):
            while stack and num < arr[stack[-1]]:
                stack.pop()
            l[idx] = -1 if not stack else stack[-1]
            stack.append(idx)
        stack.clear()
        for i in range(n - 1, -1, -1):
            while stack and arr[i] <= arr[stack[-1]]:
                stack.pop()
            r[i] = n if not stack else stack[-1]
            stack.append(i)
            ans = ans + (arr[i] * ((i - l[i]) * (r[i] - i))) % MOD
            ans%=MOD
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().sumSubarrayMins([3, 1, 2, 4]))
