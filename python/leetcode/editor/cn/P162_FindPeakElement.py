from typing import (
    List,
)  # leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)

        def get(i: int) -> int:
            if i == -1 or i == n:
                return float('-inf')
            return nums[i]

        left,right,ans=0,n-1,-1
        while left<=right:
            mid=left+(right-left)//2
            if get(mid-1)<get(mid)>get(mid+1):
                return mid
            if get(mid)<get(mid+1):
                left=mid+1
            else:
                right=mid-1
        return -1

# leetcode submit region end(Prohibit modification and deletion)
