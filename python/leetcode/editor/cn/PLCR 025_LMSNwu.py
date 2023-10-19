from typing import List

from leetcode.editor.cn.dataStruct.ListNode import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        stack1 = []
        stack2 = []
        while l1:
            stack1.append(l1)
            l1 = l1.next
        while l2:
            stack2.append(l2)
            l2 = l2.next
        carry = 0
        nxt = None
        res = None
        while stack1 or stack2:
            if stack1:
                t1 = stack1.pop().val
            else:
                t1 = 0
            if stack2:
                t2 = stack2.pop().val
            else:
                t2 = 0
            res = ListNode((t1 + t2 + carry) % 10)
            carry = 1 if (t1 + t2 + carry) >= 10 else 0
            res.next = nxt
            nxt = res
        if carry:
            res = ListNode(next=res, val=1)
        return res
# leetcode submit region end(Prohibit modification and deletion)
