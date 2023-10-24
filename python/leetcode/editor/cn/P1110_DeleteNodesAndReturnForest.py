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
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        ans = []
        s = set(to_delete)

        def recursion(node: TreeNode) -> TreeNode:
            if not node:
                return None
            node.left = recursion(node.left)
            node.right = recursion(node.right)
            if node.val not in s:
                return node
            if node.left:
                ans.append(node.left)
            if node.right:
                ans.append(node.right)
            return None

        if recursion(root):
            ans.append(root)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
