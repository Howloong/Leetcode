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
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        if not root:
            return []
        res: List[str] = []

        def preOrder(node: TreeNode, path: List[str]):
            if not node:
                return
            path.append(str(node.val))
            if not node.left and not node.right:
                res.append('->'.join(path))
                path.pop()
                return
            preOrder(node.left, path)
            preOrder(node.right, path)
            path.pop()

        preOrder(root, [])
        return res
# leetcode submit region end(Prohibit modification and deletion)
