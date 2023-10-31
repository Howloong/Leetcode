from collections import deque
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
    depth = 0

    def maxDepth1(self, root: Optional[TreeNode]) -> int:
        def func(node: TreeNode) -> int:
            if node is None:
                return 0
            left = func(node.left) + 1
            right = func(node.right) + 1
            return max(left, right)

        return func(node=root)

    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        res = 0
        cur = deque([root])
        while cur:
            res += 1
            for _ in range(len(cur)):
                node = cur.pop()
                if node.left:
                    cur.appendleft(node.left)
                if node.right:
                    cur.appendleft(node.right)
        return res


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().maxDepth(createTree([3, 9, 20, None, None, 15, 7])))
