from typing import List, Optional

from leetcode.editor.cn.dataStruct.TreeNode import TreeNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        t = 0

        def dfs(node: TreeNode) -> None:
            if not node:
                return
            nonlocal t
            dfs(node.right)
            t += node.val
            node.val = t
            dfs(node.left)

        dfs(root)
        return root
# leetcode submit region end(Prohibit modification and deletion)
