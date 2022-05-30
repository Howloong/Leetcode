//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1407 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.DataStruct.ListNode;

//*/Java：两两交换链表中的节点
class P24_SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24_SwapNodesInPairs().new Solution();
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
        public ListNode swapPairs(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            ListNode temp, f, pre;
            f = new ListNode(-1, head);
            pre = f;
            while (pre.next != null && pre.next.next != null) {
                temp = head.next.next;
                pre.next = head.next;
                head.next.next = head;
                head.next = temp;
                pre = head;
                head = temp;
            }
            return f.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
