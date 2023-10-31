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
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        res = []
        cur = deque([root])
        while cur:
            val = []
            for _ in range(len(cur)):
                node = cur.pop()
                val.append(node.val)
                if node.left:
                    cur.appendleft(node.left)
                if node.right:
                    cur.appendleft(node.right)
            res = val
        return res[0]


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().findBottomLeftValue(createTree([2,1,3])))
print(Solution().findBottomLeftValue(createTree([1, 2, 3, 4, None, 5, 6, None, None, 7])))
