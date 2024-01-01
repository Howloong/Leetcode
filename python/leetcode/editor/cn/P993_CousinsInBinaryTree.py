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
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        s = set()
        h1, h2 = 0, 0

        def preOrder(node: Optional[TreeNode], x: int, y: int, k: int) -> None:
            if not node:
                return
            nonlocal s, h1, h2
            if node.left and node.left.val == x or node.right and node.right.val == x:
                s.add(node)
                h1 = k
            if node.left and node.left.val == y or node.right and node.right.val == y:
                s.add(node)
                h2 = k
            preOrder(node.left, x, y, k + 1)
            preOrder(node.right, x, y, k + 1)

        preOrder(root, x, y, 0)
        return len(s) != 1 and h1 == h2
# leetcode submit region end(Prohibit modification and deletion)
