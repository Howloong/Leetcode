from typing import Optional

from leetcode.editor.cn.dataStruct.ListNode import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        p0 = head
        n = 0
        while p0:
            n += 1
            p0 = p0.next
        dummy = ListNode(next=head)
        p0 = dummy
        while n >= k:
            n -= k
            pre = None
            cur = p0.next
            for _ in range(k):
                nxt = cur.next
                cur.next = pre
                pre = cur
                cur = nxt
            temp = p0.next
            p0.next.next = cur
            p0.next = pre
            p0 = temp
        return dummy.next

# leetcode submit region end(Prohibit modification and deletion)
