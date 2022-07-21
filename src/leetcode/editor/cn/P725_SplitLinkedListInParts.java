//给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。 
//
// 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。 
//
// 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。 
//
// 返回一个由上述 k 部分组成的数组。 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3], k = 5
//输出：[[1],[2],[3],[],[]]
//解释：
//第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
//最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
//输出：[[1,2,3,4],[5,6,7],[8,9,10]]
//解释：
//输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 1000] 
// 0 <= Node.val <= 1000 
// 1 <= k <= 50 
// 
// Related Topics 链表 👍 267 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.DataStruct.ListNode;

import java.util.Arrays;

//Java：分隔链表
class P725_SplitLinkedListInParts {
    public static void main(String[] args) {
        Solution solution = new P725_SplitLinkedListInParts().new Solution();
//        ListNode p1 = new ListNode(10);
//        ListNode p2 = new ListNode(9, p1);
//        ListNode p3 = new ListNode(8, p2);
//        ListNode p4 = new ListNode(7, p3);
//        ListNode p5 = new ListNode(6, p4);
//        ListNode p6 = new ListNode(5, p5);
//        ListNode p7 = new ListNode(4, p6);
//        ListNode p8 = new ListNode(3, p7);
        ListNode p9 = new ListNode(2);
        ListNode p10 = new ListNode(1, p9);
        System.out.println(Arrays.toString(solution.splitListToParts(p10, 1)));
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
        public ListNode[] splitListToParts(ListNode head, int k) {
            int len = 0;
            ListNode p = head;
            while (p != null) {
                p = p.next;
                len++;
            }
            ListNode[] nodes = new ListNode[k];
            if (len <= k) {
                p = head;
                int i = 0;
                while (i < k) {
                    if (p == null) {
                        nodes[i] = null;
                    } else {
                        nodes[i] = p;
                        p = p.next;
                        nodes[i].next = null;
                    }
                    i++;
                }
                return nodes;
            }
            p = head;
            int i = 0;
            int index = 0;
            int temp = len / k;
            ListNode pre = null;
            int j = 0;
            while (j < (len % k)) {
                nodes[index++] = p;
                i = 0;
                if (pre != null)
                    pre.next = null;
                while (i < (temp + 1)) {
                    i++;
                    pre = p;
                    p = p.next;
                }
                j++;
            }
            i = 0;
            while (index < k) {
                if (i % temp == 0) {
                    if (pre != null)
                        pre.next = null;
                    nodes[index] = p;
                    index++;
                }
                pre = p;
                p = p.next;
                i++;
            }
            return nodes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
