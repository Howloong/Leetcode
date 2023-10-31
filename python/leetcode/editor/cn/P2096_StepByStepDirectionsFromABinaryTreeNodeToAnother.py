from typing import Optional, List

from leetcode.editor.cn.dataStruct.TreeNode import TreeNode, createTree


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        path: List[str] = []

        def dfs(node: TreeNode, target: int) -> bool:
            if not node:
                return False
            if node.val == target:
                return True
            path.append('L')
            if dfs(node.left, target):
                return True
            path.pop()
            path.append('R')
            if dfs(node.right, target):
                return True
            path.pop()
            return False

        dfs(root, startValue)
        path1 = list(path)
        path.clear()
        dfs(root, destValue)
        path2 = path
        while len(path1) and len(path2) and path1[0] == path2[0]:
            path1.pop(0)
            path2.pop(0)
        return ''.join("U" * len(path1)) + ''.join(path2)


# leetcode submit region end(Prohibit modification and deletion)
t = createTree([2,1])
print(Solution().getDirections(t, 2,1))
