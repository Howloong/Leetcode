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
    # def isValidBST1(self, root: Optional[TreeNode]) -> bool:
    #     def func(root: TreeNode, left: int = -inf, right: int = inf) -> bool:
    #         if root is None:
    #             return True
    #         x = root.val
    #         return left < x < right and func(root.left, left, x) and func(root.right, x, right)
    #
    #     return func(root)
    #
    # pre = -inf
    #
    # def isValidBST2(self, root: Optional[TreeNode]) -> bool:
    #     if not root:
    #         return True
    #     if not self.isValidBST2(root.left):
    #         return False
    #     if root.val <= self.pre:
    #         return False
    #     self.pre = root.val
    #     return self.isValidBST2(root.right)

    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def postOrder(node: TreeNode) -> (int, int):
            if not node:
                return inf, -inf
            x = node.val
            l_min, l_max = postOrder(node.left)
            if x <= l_max:
                return -inf, inf
            r_min, r_max = postOrder(node.right)
            if x >= r_min:
                return -inf, inf
            return min(l_min, x), max(r_max, x)

        return postOrder(root)[0] != -inf
        # leetcode submit region end(Prohibit modification and deletion)
