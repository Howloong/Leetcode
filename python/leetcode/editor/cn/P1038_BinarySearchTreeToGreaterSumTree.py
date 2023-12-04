from leetcode.editor.cn.dataStruct.TreeNode import TreeNode, createTree, printTree


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstToGst(self, root: TreeNode) -> TreeNode:
        t = 0

        def dfs(node: TreeNode) -> None:
            if not node:
                return
            nonlocal t
            dfs(node.right)
            t += node.val
            node.val = t
            dfs(node.left)

        dfs(root)
        return root
    # leetcode submit region end(Prohibit modification and deletion)


t = Solution().bstToGst(createTree([4, 1, 6, 0, 2, 5, 7, None, None, None, 3, None, None, None, 8]))
printTree(t)
