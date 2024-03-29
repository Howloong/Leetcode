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
    def lcaDeepestLeaves1(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        res = None
        _max = 0

        def recursion(node: TreeNode, depth: int) -> int:
            if not node:
                return depth
            left = recursion(node.left, depth + 1)
            right = recursion(node.right, depth + 1)
            curMax = max(left, right)
            nonlocal _max, res
            _max = max(curMax, _max)
            if left == right == _max:
                res = node
            return curMax

        recursion(root, 0)
        return res

    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def recursion(node: TreeNode) -> (int, TreeNode):
            if not node:
                return 0, None
            left_height, left_ancestor = recursion(node.left)
            right_height, right_ancestor = recursion(node.right)
            if left_height > right_height:
                return left_height + 1, left_ancestor
            if left_height < right_height:
                return right_height + 1, right_ancestor
            return left_height + 1, node

        return recursion(root)[1]
        # leetcode submit region end(Prohibit modification and deletion)
