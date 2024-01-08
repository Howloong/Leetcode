from typing import Optional

from leetcode.editor.cn.dataStruct.ListNode import ListNode, createList, traversal_listnodes


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def gcd(num1: int, num2: int) -> int:
            return num1 if not num2 else gcd(num2, num1 % num2)

        p = head
        q = head.next
        while q:
            tmp = ListNode(gcd(q.val, p.val), next=q)
            p.next = tmp
            p = q
            q = q.next
        return head


# leetcode submit region end(Prohibit modification and deletion)
t = Solution().insertGreatestCommonDivisors(createList([18, 6, 10, 3]))
print(traversal_listnodes(t))
