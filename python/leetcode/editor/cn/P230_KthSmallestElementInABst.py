from typing import Optional

from leetcode.editor.cn.dataStruct.TreeNode import TreeNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    # def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
    #     res = 0
    #     cur = 0

    #         def inOrder(node: TreeNode):
    #             if not node:
    #                 return
    #             inOrder(node.left)
    #             nonlocal cur
    #             cur += 1
    #             if cur == k:
    #                 nonlocal res
    #                 res = node.val
    #                 return
    #             inOrder(node.right)

    #         inOrder(root)
    #         return res
    # def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
    #     stack = []
    #     while root or stack:
    #         while root:
    #             stack.append(root)
    #             root = root.left
    #         root = stack.pop()
    #         k -= 1
    #         if not k:
    #             return root.val
    #         root = root.right
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        while root:
            if not root.left:
                # 没有左子树，则可以直接访问该节点，然后访问右子树。
                k -= 1
                if not k:
                    return root.val
                root = root.right
            else:
                # 有左子树，就需要找到当前节点的前驱结点，前驱节点在左子树的最右侧
                # 同时需要判断是第一次访问还是第二次访问，如果是第一次访问则右节点一定是空的
                pre: TreeNode = root.left
                # 如果是第二次访问的话，pre.right==root，会死循环
                while pre.right and pre.right is not root:
                    pre = pre.right
                # 如果是第一次访问的话，则将pre与root相连
                # 并且继续向左访问
                if not pre.right:
                    pre.right = root
                    root = root.left
                # 第二次访问
                else:
                    # 消除链接，因为涉及到了对图的修改
                    pre.right = None
                    k -= 1
                    if not k:
                        return root.val
                    # 该节点访问完了，接下来访问右子树
                    root = root.right


# leetcode submit region end(Prohibit modification and deletion)
t = TreeNode(left=TreeNode(val=1, right=TreeNode(2)), right=TreeNode(val=4), val=3)
print(Solution().kthSmallest(t, 1))
