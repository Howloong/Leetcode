//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 784 👎 0

package leetcode.editor.cn.java;

import leetcode.editor.cn.java.DataStruct.TreeNode;

import java.util.ArrayDeque;

//Java：二叉树的最小深度
class P111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
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
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
            arrayDeque.offer(root);
            int depth = 1;
            while (!arrayDeque.isEmpty()) {
                int len = arrayDeque.size();
                while (len > 0) {
                    TreeNode p = arrayDeque.poll();
                    if (p.left != null) {
                        arrayDeque.offer(p.left);
                    }
                    if (p.right != null) {
                        arrayDeque.offer(p.right);
                    }
                    if (p.left == null && p.right == null) {
                        return depth;
                    }
                    --len;
                }
                ++depth;
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
