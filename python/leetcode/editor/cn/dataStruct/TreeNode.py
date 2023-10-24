from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def createTree(vals: List[int]) -> Optional[TreeNode]:
    """根据层序遍历结果(包含None)构建二叉树

    :param vals: List
    :return: TreeNode
    """
    if not vals:
        return None
    root = TreeNode(vals.pop(0))
    temp = [root]
    while vals:
        for i in range(len(temp)):
            node = temp.pop(0)
            if len(vals) >= 1:
                left_val = vals.pop(0)
                if left_val is not None:
                    node.left = TreeNode(left_val)
                    temp.append(node.left)
            if len(vals) >= 1:
                right_val = vals.pop(0)
                if right_val is not None:
                    node.right = TreeNode(right_val)
                    temp.append(node.right)
    return root


# 用来打印输出结果对比看
def printTree(root: TreeNode) -> List[List[int]]:
    """二叉树层序遍历

    :param root: TreeNode
    :return: List[List[int]]
    """
    if not root:
        return []
    res = [root]
    ans = []
    while res:
        l = len(res)
        temp = []
        for i in range(l):
            node = res.pop(0)
            temp.append(node.val)
            if node.left:
                res.append(node.left)
            if node.right:
                res.append(node.right)
        ans.append(temp)
    print(ans)
    return ans
