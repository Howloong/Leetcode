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
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        def func(node: TreeNode, depth: int) -> None:
            if node is None:
                return
            nonlocal res
            if len(res) == depth:
                res.append(node.val)
            func(node.right, depth + 1)
            func(node.left, depth + 1)

        func(root,0)
        return res
# leetcode submit region end(Prohibit modification and deletion)
