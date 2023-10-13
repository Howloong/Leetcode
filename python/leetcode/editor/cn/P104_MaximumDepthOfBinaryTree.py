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
    depth = 0

    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def func(node: TreeNode) -> int:
            if node is None:
                return 0
            left = func(node.left) + 1
            right = func(node.right) + 1
            return max(left, right)
        return func(node=root)
# leetcode submit region end(Prohibit modification and deletion)
