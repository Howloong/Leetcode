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
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        left = self.minDepth(root.left)
        right = self.minDepth(root.right)
        return min(left, right) + 1 if left and right else left + right + 1

    def minDepth2(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        res = 0
        cur = deque([root])
        while cur:
            for _ in range(len(cur)):
                node = cur.pop()
                res += 1
                if not node.left and not node.right:
                    return res
                if node.left:
                    cur.appendleft(node.left)
                if node.right:
                    cur.appendleft(node.right)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().minDepth2(createTree([3, 9, 20, None, None, 15, 7])))
print(Solution().minDepth2(createTree([2, None, 3, None, 4, None, 5, None, 6])))
