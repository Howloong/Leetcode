from collections import deque
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
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        q = deque([root])
        level = 1
        while q:
            if level % 2 == 0:
                l, r = 0, len(q) - 1
                while l < r:
                    q[l].val, q[r].val = q[r].val, q[l].val
                    l, r = l + 1, r - 1
            for _ in range(len(q)):
                t = q.pop()
                if t.left:
                    q.appendleft(t.left)
                    q.appendleft(t.right)
            level += 1
        return root


# leetcode submit region end(Prohibit modification and deletion)
printTree(Solution().reverseOddLevels(createTree([1])))
printTree(Solution().reverseOddLevels(createTree([i for i in range(1, 64)])))
