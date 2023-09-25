//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2567 👎 0

package leetcode.editor.cn;


import leetcode.editor.cn.DataStruct.ListNode;

//Java:合并 K 个升序链表
//Time:2023-08-12 17:01:02
class P23_MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23_MergeKSortedLists().new Solution();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(1);
        l3.next = l2;
        l2.next = l1;
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(1);
        l6.next = l5;
        l5.next = l4;
        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(2);
        l8.next = l7;
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            ListNode first, second;
            first = lists[0];
            second = lists[1];
            int index = 2;
            while (index != lists.length) {
                first = sort(first, second);
                second = lists[index++];
            }
            return sort(first, second);
        }

        public ListNode sort(ListNode list1, ListNode list2) {
            ListNode res = new ListNode();
            ListNode t = res;
            ListNode p = list1;
            ListNode q = list2;
            while (p != null && q != null) {
                if (p.val < q.val) {
                    res.next = p;
                    p = p.next;
                } else {
                    res.next = q;
                    q = q.next;
                }
                res = res.next;
            }
            if (p != null) {
                while (p != null) {
                    res.next = p;
                    p = p.next;
                    res = res.next;
                }
            } else {
                while (q != null) {
                    res.next = q;
                    q = q.next;
                    res = res.next;
                }
            }
            return t.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
