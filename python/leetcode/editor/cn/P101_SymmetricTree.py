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
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def func(p: TreeNode, q: TreeNode):
            if p is None or q is None:
                return p is q
            return p.val == q.val and func(p.left, q.right) and func(p.right, q.left)
        return func(root.left,root.right)
# leetcode submit region end(Prohibit modification and deletion)
