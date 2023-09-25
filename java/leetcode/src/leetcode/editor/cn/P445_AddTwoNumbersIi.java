//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
//
// Related Topics 栈 链表 数学 👍 661 👎 0

package leetcode.editor.cn;


import leetcode.editor.cn.DataStruct.ListNode;

import java.util.ArrayDeque;

//Java:两数相加 II
//Time:2023-07-03 21:52:59
class P445_AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new P445_AddTwoNumbersIi().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ArrayDeque<ListNode> stack1 = new ArrayDeque<>();
            ArrayDeque<ListNode> stack2 = new ArrayDeque<>();
            while (l1 != null) {
                stack1.push(l1);
                l1 = l1.next;
            }
            while (l2 != null) {
                stack2.push(l2);
                l2 = l2.next;
            }
            int carry = 0;
            ListNode head = new ListNode();
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                int a = stack1.isEmpty() ? 0 : stack1.pop().val;
                int b = stack2.isEmpty() ? 0 : stack2.pop().val;
                int t = a + b + carry;
                carry = t >= 10 ? 1 : 0;
                ListNode temp = new ListNode(t % 10);
                temp.next = head.next;
                head.next = temp;
            }
            if (carry == 1) {
                ListNode temp = new ListNode(1);
                temp.next = head.next;
                head.next = temp;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
