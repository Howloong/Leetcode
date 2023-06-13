//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1457 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.DataStruct.ListNode;

import java.util.ArrayDeque;

//Java:回文链表
//Time:2022-07-31 23:35:38
class P234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234_PalindromeLinkedList().new Solution();
//        ListNode listNode4 = new ListNode(1);
//        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(1, null);
        ListNode listNode5 = new ListNode(2, listNode2);
        ListNode listNode1 = new ListNode(1, listNode5);
        System.out.println(solution.isPalindrome(listNode1));

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
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            ArrayDeque<Integer> list = new ArrayDeque<>();
            list.addLast(slow.val);
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
                fast = fast.next;
                if (fast == null) {
                    break;
                }
                list.addLast(slow.val);
            }
//            list.addLast(slow.val);

            while (slow != null) {
                if (slow.val != list.getLast()) {
                    return false;
                }
                list.removeLast();
                slow = slow.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
