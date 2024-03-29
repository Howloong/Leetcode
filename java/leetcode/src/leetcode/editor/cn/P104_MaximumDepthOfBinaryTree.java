//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1279 👎 0

package leetcode.editor.cn;


import leetcode.editor.cn.DataStruct.TreeNode;

import java.util.ArrayDeque;

//Java：二叉树的最大深度
class P104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int depth = 0;
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
            arrayDeque.offer(root);
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
                    --len;
                }
                ++depth;
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
