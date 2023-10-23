from typing import Optional

from leetcode.editor.cn.dataStruct.ListNode import ListNode


# leetcode submit region begin(Prohibit modification and deletion)

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        p0 = ListNode(next=head)
        p1 = p0
        dummy = p0
        while n:
            p0 = p0.next
            n -= 1
        while p0.next:
            p0 = p0.next
            p1 = p1.next
        p1.next = p1.next.next
        return dummy.next
# leetcode submit region end(Prohibit modification and deletion)
