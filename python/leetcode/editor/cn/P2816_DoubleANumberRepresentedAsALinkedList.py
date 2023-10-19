from typing import Optional

from leetcode.editor.cn.dataStruct.ListNode import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    # def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
    #     stack = []
    #     while head:
    #         stack.append(head)
    #         head = head.next
    #     res = None
    #     nxt = None
    #     carry = 0
    #     while stack:
    #         t = stack.pop().val * 2
    #         res = ListNode(next=nxt, val=(t + carry) % 10)
    #         carry = (t + carry) >= 10
    #         nxt = res
    #     return res if not carry else ListNode(next=res, val=1)
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:

        def reverse(l: ListNode):
            pre = None
            p0 = l
            while p0:
                nxt = p0.next
                p0.next = pre
                pre = p0
                p0 = nxt
            return pre

        p0 = head
        head = reverse(head)
        p1 = head

        carry = 0

        while head:
            t = head.val << 1
            head.val = (t + carry) % 10
            carry = 1 if t + carry >= 10 else 0
            head = head.next
        if carry:
            p0.next = ListNode(val=1)
        return reverse(p1)
# leetcode submit region end(Prohibit modification and deletion)
