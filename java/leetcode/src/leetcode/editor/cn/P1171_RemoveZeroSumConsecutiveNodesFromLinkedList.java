//给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。 
//
// 删除完毕后，请你返回最终结果链表的头节点。 
//
// 
//
// 你可以返回任何满足题目要求的答案。 
//
// （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。） 
//
// 示例 1： 
//
// 输入：head = [1,2,-3,3,1]
//输出：[3,1]
//提示：答案 [1,2,1] 也是正确的。
// 
//
// 示例 2： 
//
// 输入：head = [1,2,3,-3,4]
//输出：[1,2,4]
// 
//
// 示例 3： 
//
// 输入：head = [1,2,3,-3,-2]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 给你的链表中可能有 1 到 1000 个节点。 
// 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000. 
// 
//
// Related Topics 哈希表 链表 👍 270 👎 0

package leetcode.editor.cn;


import leetcode.editor.cn.DataStruct.ListNode;

import java.util.HashMap;

//Java:从链表中删去总和值为零的连续节点
//Time:2023-06-11 21:30:34
class P1171_RemoveZeroSumConsecutiveNodesFromLinkedList {
    public static void main(String[] args) {
        Solution solution = new P1171_RemoveZeroSumConsecutiveNodesFromLinkedList().new Solution();
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(-3);
        ListNode p5 = new ListNode(-2);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        solution.removeZeroSumSublists(p1);
        System.out.println(1);
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
        public ListNode removeZeroSumSublists(ListNode head) {
            int pre = 0;
            HashMap<Integer, ListNode> hashMap = new HashMap<>();
            ListNode p = new ListNode();
            hashMap.put(0, p);
            p.next = head;
            head = p;
            p = p.next;
            while (p != null) {
                pre += p.val;
                if (hashMap.containsKey(pre)) {
                    ListNode first = hashMap.get(pre);
                    ListNode temp2 = p, temp1 = first.next;
                    int m = pre;
                    while (temp1 != temp2) {
                        m += temp1.val;
                        hashMap.remove(m);
                        temp1 = temp1.next;
                    }
                    temp2 = temp2.next;
                    delete(first, p);
                    p = temp2;
                } else {
                    hashMap.put(pre, p);
                    p = p.next;
                }
            }
            return head.next;
        }

        public void delete(ListNode begin, ListNode end) {
            begin.next = end.next;
            end.next = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
