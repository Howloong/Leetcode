from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class NumArray:

    def __init__(self, nums: List[int]):
        n = len(nums)
        tree = [0] * (n + 1)
        for i, x in enumerate(nums, 1):
            tree[i] += x
            nxt = i + (i & -i)
            if nxt <= n:
                tree[nxt] += tree[i]
        self.tree = tree
        self.nums = nums

    def update(self, index: int, val: int) -> None:
        delta = val - self.nums[index]
        self.nums[index] = val
        i = index + 1
        while i < len(self.tree):
            self.tree[i] += delta
            i += i & -i

    def prefixSum(self, i: int) -> int:
        s = 0
        while i:
            s += self.tree[i]
            i &= i - 1
        return s

    def sumRange(self, left: int, right: int) -> int:
        return self.prefixSum(right + 1) - self.prefixSum(left)


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)
# leetcode submit region end(Prohibit modification and deletion)
n = NumArray([1, 3, 5])
print(n.sumRange(0, 2))
n.update(1, 2)
print(n.sumRange(0, 2))
