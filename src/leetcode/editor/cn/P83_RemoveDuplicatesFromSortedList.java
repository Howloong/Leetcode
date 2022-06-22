//给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 👍 811 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.DataStruct.ListNode;

//Java：删除排序链表中的重复元素
class P83_RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new P83_RemoveDuplicatesFromSortedList().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode t = head;
            ListNode p = head;
            ListNode q = p;
            while (q != null) {
                q = q.next;
                while (q != null && p.val == q.val) {
                    q = q.next;
                }
                p.next = q;
                p = q;
            }
            return t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
