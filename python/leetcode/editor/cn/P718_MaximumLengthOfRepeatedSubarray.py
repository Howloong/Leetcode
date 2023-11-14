from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findLength(nums2, nums1)

        b = 131313
        MOD = 10 ** 9 + 7
        N = 1010
        h1 = [0] * N
        h2 = [0] * N
        p = [0] * N
        p[0] = 1

        for i in range(1, n1 + 1):
            h1[i] = (h1[i - 1] * b + nums1[i - 1]) % MOD
            p[i] = (p[i - 1] * b) % MOD
        for i in range(1, n2 + 1):
            h2[i] = (h2[i - 1] * b + nums2[i - 1]) % MOD
            p[i] = (p[i - 1] * b) % MOD

        def func(window_size: int) -> bool:
            i = 1
            s = set()
            while i + window_size - 1 <= n1:
                j = i + window_size - 1
                _hash1 = (h1[j] - h1[i - 1] * p[j - i + 1]) % MOD
                s.add(_hash1)
                i += 1
            i = 1
            while i + window_size - 1 <= n2:
                j = i + window_size - 1
                _hash2 = (h2[j] - h2[i - 1] * p[j - i + 1]) % MOD
                if _hash2 in s:
                    return True
                i += 1
            return False

        left, right = 0, n1
        while left <= right:
            mid = (left + right) >> 1
            if func(mid):
                left = mid + 1
            else:
                right = mid - 1
        return right


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().findLength([1, 2, 3, 2, 1], [3, 2, 1, 4, 7]))
print(Solution().findLength([0, 0, 0, 0, 0], [0, 0, 0, 0, 0]))
