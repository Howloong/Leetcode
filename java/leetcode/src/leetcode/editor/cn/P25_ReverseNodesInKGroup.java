//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 1734 👎 0

package leetcode.editor.cn;


import leetcode.editor.cn.DataStruct.ListNode;

//Java:K 个一组翻转链表
//Time:2022-07-30 22:23:11
class P25_ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new P25_ReverseNodesInKGroup().new Solution();
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        solution.reverseKGroup(node1, 2);
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0, head);
            ListNode tail = dummy;
            ListNode pre = dummy;
            while (true) {
                int i = 0;
                while (tail != null && i != k) {
                    tail = tail.next;
                    i++;
                }
                if (tail == null) {
                    return dummy.next;
                }
                ListNode l = tail.next;
                reverse(head, k);
                pre.next = tail;
                pre = head;
                tail = head;
                head.next = l;
                head = l;
            }
        }

        public void reverse(ListNode node, int k) {
            ListNode p = node;
            ListNode q = p.next;
            while (k > 1) {
                ListNode r = q.next;
                q.next = p;
                p = q;
                q = r;
                k--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
