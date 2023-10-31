from leetcode.editor.cn.dataStruct.TreeNode import TreeNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:
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

        # leetcode submit region end(Prohibit modification and deletion)
