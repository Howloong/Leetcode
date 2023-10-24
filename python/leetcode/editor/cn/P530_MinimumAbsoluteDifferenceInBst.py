from math import inf
from typing import Optional

from leetcode.editor.cn.dataStruct.TreeNode import TreeNode,  createTree, printTree


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        p: int = inf
        ans = inf

        def updateAns():
            nonlocal ans, p
            ans = min(abs(p - root.val), ans)
            p = root.val

        while root:
            if not root.left:
                updateAns()
                root = root.right
            else:
                pre: TreeNode = root.left
                while pre.right and pre.right is not root:
                    pre = pre.right
                if not pre.right:
                    pre.right = root
                    root = root.left
                else:
                    updateAns()
                    root = root.right
        return ans


# leetcode submit region end(Prohibit modification and deletion)
print(printTree(createTree([1, 0, 48, None, None, 12, 49])))
