from typing import List


def binarySearch(nums: List[int], target: int):
    left = 0
    right = len(nums) - 1
    while left <= right:
        mid = left + (right - left) // 2
        if nums[mid] > target:
            right = mid - 1
        else:
            left = mid + 1
    return left - 1


print(binarySearch([1, 2, 3, 4, 5, 6, 7], 4))
