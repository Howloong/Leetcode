from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumRemovals(self, s: str, p: str, removable: List[int]) -> int:
        ns = len(s)
        np = len(p)

        def check(k: int) -> bool:
            state = [False] * ns
            for i in range(k):
                state[removable[i]] = True
            j = 0
            for i in range(ns):
                if not state[i] and s[i] == p[j]:
                    j += 1
                    if j == np:
                        return True
            return False

        left, right = 0, len(removable)
        while left <= right:
            mid = (left + right) // 2
            if check(mid):
                left = mid + 1
            else:
                right = mid - 1
        return left - 1


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maximumRemovals("qlevcvgzfpryiqlwy", "qlecfqlw", [12, 5]))
print(Solution().maximumRemovals("qobftgcueho", "obue", [5, 3, 0, 6, 4, 9, 10, 7, 2, 8]))
print(Solution().maximumRemovals("abcacb", "ab", [3, 1, 0]))
print(Solution().maximumRemovals("abcbddddd", "abcd", [3, 2, 1, 4, 5, 6]))
print(Solution().maximumRemovals("abcab", "abc", [0, 1, 2, 3, 4]))
