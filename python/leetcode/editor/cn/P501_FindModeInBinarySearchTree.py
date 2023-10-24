from math import inf
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
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        res: List[int] = []
        pre: int = -inf
        cnt_cur = 0
        cnt_max = 0

        def updateAns():
            nonlocal pre, cnt_cur, cnt_max
            if root.val == pre:
                cnt_cur += 1
            else:
                if cnt_cur > cnt_max:
                    res.clear()
                    res.append(pre)
                    cnt_max = cnt_cur
                elif cnt_cur == cnt_max:
                    res.append(pre)
                cnt_cur = 1
                pre = root.val

        while root:
            if not root.left:
                updateAns()
                root = root.right
            else:
                p: TreeNode = root.left
                while p.right and p.right is not root:
                    p = p.right
                if not p.right:
                    p.right = root
                    root = root.left
                else:
                    updateAns()
                    root = root.right
        if cnt_cur > cnt_max:
            return [pre]
        if cnt_cur == cnt_max:
            res.append(pre)
        return res
        # leetcode submit region end(Prohibit modification and deletion)

