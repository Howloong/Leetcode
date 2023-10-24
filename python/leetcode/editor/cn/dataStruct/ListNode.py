from typing import List, Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def createList(li: List[int]) -> Optional[ListNode]:
    """根据列表构建链表

    :param li: List[int]
    :return: ListNode
    """
    if not li:
        return
    head = ListNode(li[0])
    cur = head
    for i in range(1, len(li)):
        node = ListNode(li[i])
        cur.next = node
        cur = cur.next
    return head


def traversal_listnodes(head: ListNode) -> None:
    """遍历链表

    :param head: ListNode
    :return: None
    """
    while head:
        print(head.val, end=' ')
        head = head.next
