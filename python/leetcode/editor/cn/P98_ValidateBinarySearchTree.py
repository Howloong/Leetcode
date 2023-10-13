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
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def func(root: TreeNode, left: int = -inf, right: int = inf) -> bool:
            if root is None:
                return True
            x = root.val
            return left < x < right and func(root.left, left, x) and func(root.right, x, right)
        return func(root)
        # leetcode submit region end(Prohibit modification and deletion)
