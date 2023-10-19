from typing import Optional

from leetcode.editor.cn.dataStruct.ListNode import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def addTwoNumbers1(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
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

    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        def reverseList(l: ListNode) -> ListNode:
            pre = None
            p0 = l
            while p0:
                nxt = p0.next
                p0.next = pre
                pre = p0
                p0 = nxt
            return pre

        l1 = reverseList(l1)
        l2 = reverseList(l2)
        res = None
        nxt = None
        carry = 0
        while l1 or l2:
            t1 = l1.val if l1 else 0
            t2 = l2.val if l2 else 0
            res = ListNode(next=nxt, val=(t1 + t2 + carry) % 10)
            carry = 1 if (t1 + t2 + carry) >= 10 else 0
            nxt = res
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
        if carry:
            return ListNode(next=res, val=1)
        return res


# leetcode submit region end(Prohibit modification and deletion)
t = Solution().addTwoNumbers(ListNode(val=1), ListNode(val=9, next=ListNode(9)))
print(t)
