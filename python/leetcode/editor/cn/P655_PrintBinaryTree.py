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
    height = 0

    def printTree(self, root: Optional[TreeNode]) -> List[List[str]]:
        if root is None:
            return []

        def getHeight(root: TreeNode, h):
            if not root:
                self.height = max(self.height, h)
                return
            getHeight(root.left, h + 1)
            getHeight(root.right, h + 1)

        def func(node: TreeNode, res: List[List], x: int, y: int):
            if not node:
                return
            res[x][y] = str(node.val)
            t = 2 ** (self.height - x - 1)
            func(node.left, res, x + 1, y - t)
            func(node.right, res, x + 1, y + t)

        getHeight(root, -1)
        m = self.height + 1
        n = 2 ** m - 1
        res = [[""] * (2 ** m - 1) for _ in range(m)]
        func(node=root, res=res, x=0, y=(n - 1) // 2)
        return res


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
root = TreeNode(1, left=TreeNode(2))

print(s.printTree(root))
print(s.printTree(None))
