from typing import Optional

from leetcode.editor.cn.dataStruct.ListNode import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur: ListNode = head
        if not cur:
            return None
        nxt: ListNode = cur.next
        cur.next = None
        while nxt:
            temp = nxt.next
            nxt.next = cur
            cur = nxt
            nxt = temp
        return cur

    # leetcode submit region end(Prohibit modification and deletion)

