from typing import List, Optional


# leetcode submit region begin(Prohibit modification and deletion)
class Node:
    def __init__(self):
        self.left: Optional["Node"] = None
        self.right: Optional["Node"] = None
        self.val: int = 0
        self.mark: int = 0

    def pushUp(self, node: "Node") -> None:
        node.val = node.left.val + node.right.val

    def pushDown(self, node: "Node", left_num: int, right_num: int) -> None:
        if not node.left:
            node.left = Node()
        if not node.right:
            node.right = Node()
        if not node.mark:
            return
        # 题目中是将一个区间的数替换为另一个区间的数，所以覆盖
        node.left.val = node.mark * left_num
        node.right.val = node.mark * right_num

        node.left.mark = node.mark
        node.right.mark = node.mark
        node.mark = 0

    def update(self, node: "Node", start: int, end: int, l: int, r: int, val: int) -> None:
        if l <= start and end <= r:
            node.val = (end - start + 1) * val
            node.mark = val
            return
        mid = (start + end) >> 1
        self.pushDown(node, mid - start + 1, end - mid)
        if l <= mid:
            self.update(node.left, start, mid, l, r, val)
        if r > mid:
            self.update(node.right, mid + 1, end, l, r, val)
        self.pushUp(node)

    def query(self, node: "Node", start: int, end: int, l: int, r: int) -> int:
        if l <= start and end <= r:
            return node.val
        mid = (start + end) // 2
        ans = 0
        self.pushDown(node, mid - start + 1, end - mid)
        if l <= mid:
            ans += self.query(node.left, start, mid, l, r)
        if r > mid:
            ans += self.query(node.right, mid + 1, end, l, r)
        return ans


class NumArray:

    def __init__(self, nums: List[int]):
        self.tree_node = Node()
        self.n = len(nums)
        for i in range(self.n):
            self.tree_node.update(self.tree_node, 0, self.n - 1, i, i, nums[i])

    def update(self, index: int, val: int) -> None:
        self.tree_node.update(self.tree_node, 0, self.n - 1, index, index, val)

    def sumRange(self, left: int, right: int) -> int:
        return self.tree_node.query(self.tree_node, 0, self.n - 1, left, right)


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)
# leetcode submit region end(Prohibit modification and deletion)
n = NumArray([1, 3, 5])
print(n.sumRange(0, 2))
n.update(1, 2)
print(n.sumRange(0, 2))
