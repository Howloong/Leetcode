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
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        def func(node: TreeNode) -> int:
            if node is None:
                return 0
            left = func(node.left)
            if left == -1:
                return -1
            right = func(node.right)
            if right == -1:
                return -1
            if abs(left - right) >= 2:
                return -1
            return max(left, right) + 1

        return func(root) != -1
# leetcode submit region end(Prohibit modification and deletion)
