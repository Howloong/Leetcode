from collections import deque

from leetcode.editor.cn.dataStruct.Node import Node

# leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None
        q0 = root
        queue = deque([root])
        while queue:
            _len = len(queue)
            pre = None
            for _ in range(_len):
                t = queue.popleft()
                t.next = pre
                pre = t
                if t.right:
                    queue.append(t.right)
                if t.left:
                    queue.append(t.left)

        return q0
# leetcode submit region end(Prohibit modification and deletion)
