from typing import List

from leetcode.editor.cn.dataStruct.TreeNode import TreeNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def mirrorTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        root.left = self.mirrorTree(root.left)
        root.right = self.mirrorTree(root.right)
        root.left, root.right = root.right, root.left
        return root
# leetcode submit region end(Prohibit modification and deletion)
