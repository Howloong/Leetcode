//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// Related Topics 栈 递归 链表 双指针 👍 1313 👎 0

package leetcode.editor.cn.java;

import leetcode.editor.cn.java.DataStruct.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

//Java:重排链表
//Time:2023-07-31 20:19:04
class P143_ReorderList {
    public static void main(String[] args) {
        Solution solution = new P143_ReorderList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            Deque<ListNode> deque = new ArrayDeque<>();
//            用一个栈保存Node
            while (head != null) {
                deque.push(head);
                head = head.next;
            }
            head = new ListNode();
            while (!deque.isEmpty()) {
//                取尾一个
                head.next = deque.pollLast();
                head = head.next;
                head.next = null;
//                取头一个
                if (!deque.isEmpty()) {
                    head.next = deque.pollFirst();
                    head = head.next;
                    head.next = null;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
