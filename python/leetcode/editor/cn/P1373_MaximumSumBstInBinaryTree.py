from math import inf
from typing import Optional

from leetcode.editor.cn.dataStruct.TreeNode import TreeNode, createTree


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        res = 0

        def recursion(node: TreeNode) -> (int, int, int):
            if not node:
                return inf, -inf, 0
            l_min, l_max, l_sum = recursion(node.left)
            r_min, r_max, r_sum = recursion(node.right)
            nonlocal res
            if node.val >= r_min or node.val <= l_max:
                return -inf, inf, 0
            t = l_sum + r_sum + node.val
            res = max(t, res)
            return min(l_min, node.val), max(r_max, node.val), t

        recursion(root)
        return res
        # leetcode submit region end(Prohibit modification and deletion)


print(Solution().maxSumBST(createTree([1, 4, 3, 2, 4, 2, 5, None, None, None, None, None, None, 4, 6])))
