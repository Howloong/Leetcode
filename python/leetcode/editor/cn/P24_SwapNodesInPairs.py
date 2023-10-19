from typing import Optional

from leetcode.editor.cn.dataStruct.ListNode import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(next=head)
        p0 = dummy
        cur = p0.next
        while cur and cur.next:
            pre = None
            cur = p0.next
            for _ in (1, 2):
                nxt = cur.next
                cur.next = pre
                pre = cur
                cur = nxt
            tmp = p0.next
            p0.next.next = cur
            p0.next = pre
            p0 = tmp
        return dummy.next


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().swapPairs(ListNode(1)))
# print(Solution().swapPairs(None))
