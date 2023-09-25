//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。 
//
// 如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 2³¹ - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 267 👎 0

package leetcode.editor.cn;


import leetcode.editor.cn.DataStruct.TreeNode;

import java.util.ArrayDeque;

//Java：二叉树中第二小的节点
class P671_SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new P671_SecondMinimumNodeInABinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
            arrayDeque.add(root.val);
            preOrder(root, arrayDeque);
            if (arrayDeque.size() <= 1) {
                return -1;
            }
            arrayDeque.removeLast();
            return arrayDeque.getLast();
        }

        public void preOrder(TreeNode p, ArrayDeque<Integer> arrayDeque) {
            if (p.left == null && p.right == null) {
                if (p.val > arrayDeque.getFirst()) {
                    arrayDeque.addFirst(p.val);
                } else if (p.val < arrayDeque.getFirst() && p.val != arrayDeque.getLast()) {
                    while (!arrayDeque.isEmpty() && arrayDeque.getFirst() >= p.val) {
                        arrayDeque.removeFirst();
                    }
                    arrayDeque.addFirst(p.val);
                }
            }
            if (p.left != null)
                preOrder(p.left, arrayDeque);
            if (p.right != null) {
                preOrder(p.right, arrayDeque);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
