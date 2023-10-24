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
    def sufficientSubset(self, root: Optional[TreeNode], limit: int) -> Optional[TreeNode]:
        def recursion(node: TreeNode, _sum: int) -> bool:
            if not node:
                return False
            if not node.left and not node.right:
                return _sum + node.val >= limit
            l = recursion(node.left, _sum + node.val)
            r = recursion(node.right, _sum + node.val)
            if not l:
                node.left = None
            if not r:
                node.right = None
            return l or r

        t = TreeNode(left=root, val=0)
        recursion(t, 0)
        return t.left
# leetcode submit region end(Prohibit modification and deletion)
