from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        def func(nums, k):
            res = []
            rest = len(nums) - k
            for n in nums:
                while rest and res and res[-1] < n:
                    res.pop()
                    rest -= 1
                res.append(n)
            return res[:k]

        def merge(A: List[int], B: List[int]) -> List[int]:
            res = []
            while A or B:
                bigger = A if A > B else B
                res.append(bigger[0])
                bigger.pop(0)
            return res

        return max(
            merge(func(nums1, i), func(nums2, k - i)) for i in range(k + 1) if i <= len(nums1) and k - i <= len(nums2))

    # leetcode submit region end(Prohibit modification and deletion)


print(Solution().maxNumber([3, 4, 5, 6], [9, 1, 2, 5, 8, 3], 5))
