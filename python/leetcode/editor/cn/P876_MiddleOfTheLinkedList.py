from typing import Optional

from leetcode.editor.cn.dataStruct.ListNode import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        p0 = head
        p1 = head
        while p1 and p1.next:
            p0 = p0.next
            p1 = p1.next.next
        return p0


# leetcode submit region end(Prohibit modification and deletion)
