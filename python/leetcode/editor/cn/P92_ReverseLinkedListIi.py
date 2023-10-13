from typing import List, Optional

from leetcode.editor.cn.dataStruct.ListNode import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if not head.next:
            return head
        dummy = ListNode(next=head)
        p0 = dummy
        for _ in range(left - 1):
            p0 = p0.next
        pre = None
        cur = p0.next
        for _ in range(right - left + 1):
            temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        p0.next.next = cur
        p0.next = pre
        return dummy.next


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.reverseBetween(ListNode(1), 1, 1))