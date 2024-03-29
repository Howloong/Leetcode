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
    def rightSideView1(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        def func(node: TreeNode, depth: int) -> None:
            if node is None:
                return
            nonlocal res
            if len(res) == depth:
                res.append(node.val)
            func(node.right, depth + 1)
            func(node.left, depth + 1)

        func(root, 0)
        return res

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        res = []
        cur = deque([root])
        while cur:
            res.append(cur[0].val)
            for _ in range(len(cur)):
                node = cur.pop()
                if node.left:
                    cur.appendleft(node.left)
                if node.right:
                    cur.appendleft(node.right)
        return res


# leetcode submit region end(Prohibit modification and deletion)
t = createTree([1, 2, 3, None, 5, None, 4])
print(Solution().rightSideView(t))
