from typing import Optional

from leetcode.editor.cn.dataStruct.TreeNode import TreeNode, createTree, printTree


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if not root:
            return None
        if root.val == val:
            return root
        return self.searchBST(root.left, val) if root.val > val else self.searchBST(root.right, val)


# leetcode submit region end(Prohibit modification and deletion)
t = Solution().searchBST(createTree([4, 2, 7, 1, 3]), 2)
printTree(t)
