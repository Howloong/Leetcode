from typing import Optional

from leetcode.editor.cn.dataStruct.ListNode import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
        cur = head
        while cur.next:
            if cur.val == cur.next.val:
                cur.next = cur.next.next
            else:
                cur = cur.next
        return head


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.deleteDuplicates(
    ListNode(val=1, next=ListNode(val=1, next=ListNode(val=2, next=ListNode(3, next=ListNode(3, ListNode(3))))))))
