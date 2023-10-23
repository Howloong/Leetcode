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

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []

        def recursion(root: TreeNode, target: int, path: List[TreeNode]) -> None:
            if not root:
                return
            path.append(root.val)
            if not root.left and not root.right:
                if target == root.val:
                    res.append(list(path))
                path.pop()
                return
            recursion(root.left, target - root.val, path)
            recursion(root.right, target - root.val, path)
            path.pop()

        recursion(root, targetSum, [])
        return res
# leetcode submit region end(Prohibit modification and deletion)
