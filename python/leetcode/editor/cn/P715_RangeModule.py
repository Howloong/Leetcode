from typing import Optional


# leetcode submit region begin(Prohibit modification and deletion)
class Node:
    def __init__(self):
        self.left: Optional[Node] = None
        self.right: Optional[Node] = None
        # 表示当前区间是否被覆盖
        self.cover: bool = False
        # 懒惰标记
        self.add: int = 0

    def pushUp(self, node: "Node") -> None:
        node.cover = node.left.cover and node.right.cover

    # leftNum和rightNum是左右孩子区间的叶子节点数量
    # 因为如果是加减操作，需要用懒惰标记（0或1）*叶子节点的数量
    def pushDown(self, node: "Node") -> None:
        # 动态开点
        if not node.left:
            node.left = Node()
        if not node.right:
            node.right = Node()
        # add为0，没有标记
        if not node.add:
            return
        node.left.cover = node.add == 1
        node.right.cover = node.add == 1

        node.left.add = node.add
        node.right.add = node.add
        # 取消当前节点的标记
        node.add = 0

    # 在区间[start,end]中更新区间[l,r]的值，将区间[l,r]+val
    # 如果要将区间[2,4]+1，则update(root,0,4,2,4,1)
    def update(self, node: "Node", start: int, end: int, l: int, r: int, val: int) -> None:
        # 如果区间满足条件
        if l <= start and end <= r:
            # val为1表示覆盖，-1表示没有覆盖
            node.cover = val == 1
            node.add = val
            return
        mid = (start + end) >> 1
        # 下推标记,将当前节点的情况下发到左右孩子节点
        # mid-start+1表示左孩子区间叶子节点的数量
        # end-mid表示右孩子区间叶子节点的数量
        self.pushDown(node)
        if l <= mid:
            self.update(node.left, start, mid, l, r, val)
        if r > mid:
            self.update(node.right, mid + 1, end, l, r, val)
        self.pushUp(node)

    # 在区间[start,end]中查询区间[l,r]的结果
    # 如果查询[2,4]，则query(root,0,4,2,4)
    def query(self, node: "Node", start: int, end: int, l: int, r: int) -> bool:
        # 如果[l,r]完全包含区间[start,end]
        if l <= start and end <= r:
            return node.cover
        mid = (start + end) >> 1
        ans = True
        self.pushDown(node)
        if l <= mid:
            ans = ans and self.query(node.left, start, mid, l, r)
        if r > mid:
            ans = ans and self.query(node.right, mid + 1, end, l, r)
        return ans


class RangeModule:

    def __init__(self):
        self.N = 5
        self.tree_node = Node()

    def addRange(self, left: int, right: int) -> None:
        self.tree_node.update(self.tree_node, 1, self.N, left, right - 1, 1)

    def queryRange(self, left: int, right: int) -> bool:
        return self.tree_node.query(self.tree_node, 1, self.N, left, right - 1)

    def removeRange(self, left: int, right: int) -> None:
        self.tree_node.update(self.tree_node, 1, self.N, left, right - 1, -1)


# Your RangeModule object will be instantiated and called as such:
# obj = RangeModule()
# obj.addRange(left,right)
# param_2 = obj.queryRange(left,right)
# obj.removeRange(left,right)
# leetcode submit region end(Prohibit modification and deletion)
n = RangeModule()
n.addRange(1, 5)
n.addRange(10, 180)
n.addRange(150, 200)
n.addRange(250, 500)
print(n.queryRange(50, 100))
