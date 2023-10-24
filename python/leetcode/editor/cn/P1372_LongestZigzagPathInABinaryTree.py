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
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        res = 0

        def recursion(node: TreeNode, l: int, r: int):
            nonlocal res
            res = max(res, l, r)
            # -1表示上个节点是向左的，1表示向右
            if node.left:
                recursion(node.left, r + 1, 0)
            if node.right:
                recursion(node.right, 0, l + 1)

        recursion(root, 0,0)
        return res
# leetcode submit region end(Prohibit modification and deletion)
