from math import inf
from typing import Optional

from leetcode.editor.cn.dataStruct.TreeNode import TreeNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        res = 0

        def recursion(node: TreeNode) -> (int, int):
            if not node:
                return inf, -inf
            if not node.left and not node.right:
                return node.val, node.val
            _min1, _max1 = recursion(node.left)
            _min2, _max2 = recursion(node.right)
            _min = min(_min1, _min2)
            _max = max(_max1, _max2)
            nonlocal res
            res = max(res, node.val - _min, _max - node.val)
            return min(_min, node.val), max(_max, node.val)

        recursion(root)
        return res

    def maxAncestorDiff2(self, root: Optional[TreeNode]) -> int:
        res = 0

        def recursion(node: TreeNode, _min, _max) -> (int, int):
            if not node:
                nonlocal res
                res = max(res, _max - _min)
                return
            _min = min(_min, node.val)
            _max = max(_max, node.val)
            recursion(node.left, _min, _max)
            recursion(node.right, _min, _max)

        recursion(root, root.val, root.val)
        return res

# leetcode submit region end(Prohibit modification and deletion)
