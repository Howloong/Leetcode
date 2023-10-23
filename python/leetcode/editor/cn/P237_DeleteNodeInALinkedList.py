from typing import Optional

from leetcode.editor.cn.dataStruct.ListNode import ListNode


# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def deleteNode(self, node: Optional[ListNode]):
        node.val = node.next.val
        node.next = node.next.next

# leetcode submit region end(Prohibit modification and deletion)
