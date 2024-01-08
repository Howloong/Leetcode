from typing import Optional

from leetcode.editor.cn.dataStruct.ListNode import ListNode, createList, traversal_listnodes


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        _s = [ListNode(10 ** 6)]
        while head:
            while _s and head.val > _s[-1].val:
                _s.pop()
            _s[-1].next = head
            _s.append(head)
            head = head.next
        return _s[0].next
# leetcode submit region end(Prohibit modification and deletion)
