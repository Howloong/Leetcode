from collections import deque
from typing import List, Optional

from leetcode.editor.cn.dataStruct.TreeNode import TreeNode, createTree


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        res = []
        cur = deque([root])
        while cur:
            vals = []
            for _ in range(len(cur)):
                node = cur.pop()
                vals.append(node.val)
                if node.left:
                    cur.appendleft(node.left)
                if node.right:
                    cur.appendleft(node.right)
            res.append(vals)
        return res


# leetcode submit region end(Prohibit modification and deletion)
Solution().levelOrder(createTree([3, 9, 20, None, None, 15, 7]))
