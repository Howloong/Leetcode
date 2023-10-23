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

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        res = 0

        def recursion(root: TreeNode, sum: int) -> None:
            if not root:
                return
            nonlocal res
            sum += root.val
            if not root.left and not root.right:
                res += sum
                return
            recursion(root.left, sum * 10)
            recursion(root.right, sum * 10)

        recursion(root, 0)
        return res
# leetcode submit region end(Prohibit modification and deletion)
