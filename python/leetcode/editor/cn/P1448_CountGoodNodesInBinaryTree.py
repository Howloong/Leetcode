from math import inf

from leetcode.editor.cn.dataStruct.TreeNode import TreeNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        res = 0

        def recursion(root: TreeNode, _max: int):
            if not root:
                return
            if root.val >= _max:
                nonlocal res
                res += 1
            _max = max(_max, root.val)
            recursion(root.left, _max)
            recursion(root.right, _max)
            return

        recursion(root, -10 ** 5)
        return res
# leetcode submit region end(Prohibit modification and deletion)
