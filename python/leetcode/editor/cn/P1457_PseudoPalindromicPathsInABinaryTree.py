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
    def pseudoPalindromicPaths(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(node: Optional[TreeNode], t: int):
            if not node.left and not node.right:
                nonlocal ans
                t ^= (1 << node.val)
                ans += t == (t & -t)
                return
            if node.left:
                dfs(node.left, t ^ (1 << node.val))
            if node.right:
                dfs(node.right, t ^ (1 << node.val))

        dfs(root, 0)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
t = createTree([2, 1, 1, 1, 3, None, None, None, None, None, 1])
print(Solution().pseudoPalindromicPaths(t))
