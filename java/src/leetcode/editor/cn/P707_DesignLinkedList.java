//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 👍 461 👎 0

package leetcode.editor.cn.java;


//Java：设计链表
class P707_DesignLinkedList {
    public static void main(String[] args) {
//        Solution solution = new P707_DesignLinkedList().new Solution();
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(1, 0);
        myLinkedList.get(0);
/*        myLinkedList.addAtHead(7);
        myLinkedList.addAtTail(7);
        myLinkedList.addAtHead(9);
        myLinkedList.addAtTail(8);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtHead(0);
        int i = myLinkedList.get(5);
        myLinkedList.addAtHead(0);
        int j = myLinkedList.get(2);
        int k = myLinkedList.get(5);
        myLinkedList.addAtTail(4);*/
/*        myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        int i = myLinkedList.get(1);
        myLinkedList.deleteAtIndex(0);
        int j = myLinkedList.get(0);*/
/*        myLinkedList.addAtIndex(0, 10);
        myLinkedList.addAtIndex(0, 20);
        myLinkedList.addAtIndex(1, 30);
        int i = myLinkedList.get(0);*/
    }


}

//leetcode submit region begin(Prohibit modification and deletion)


class MyLinkedList {
    public ListNode list;

    public MyLinkedList() {
        list = new ListNode(-1);

    }

    /**/
    public int get(int index) {
        if (index < list.size && index >= 0) {
            ListNode node = list.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.val;
        } else {
            return -1;
        }
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        if (list.size != 0) {
            node.next = list.next;
            node.prev = list.next.prev;
            node.prev.next = node;
            node.next.prev = node;
        } else {
            node.next = node;
            node.prev = node;
        }
        ++list.size;
        list.next = node;


    }

    public void addAtTail(int val) {
        if (list.size != 0) {
            ListNode node = new ListNode(val);
            ListNode pre = list.next.prev;
            pre.next = node;
            node.prev = pre;
            node.next = list.next;
            list.next.prev = node;
            ++list.size;
        } else {
            addAtHead(val);
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > list.size) {
            return;
        } else if (index == list.size) {
            addAtTail(val);
            return;
        } else if (index < 0) {
            addAtHead(val);
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        ListNode node = new ListNode(val);
        ListNode pre;
        pre = list.next;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        node.prev = pre;
        node.next = pre.next;
        pre.next.prev = node;
        pre.next = node;
        ++list.size;
    }

    public void deleteAtIndex(int index) {
        if (index < list.size && index >= 0) {
            ListNode node = list.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            --list.size;
            if (index == 0) {
                list.next = node.next;
            }
        }
    }

    class ListNode {
        public int val;
        public ListNode next, prev, head, tail;
        public int size;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)