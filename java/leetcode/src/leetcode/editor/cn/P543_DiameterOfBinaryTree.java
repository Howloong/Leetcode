//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1132 👎 0

package leetcode.editor.cn;


import leetcode.editor.cn.DataStruct.TreeNode;

//Java:二叉树的直径
//Time:2022-08-17 23:10:40
class P543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P543_DiameterOfBinaryTree().new Solution();
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
        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);
            return max;
        }

        public int dfs(TreeNode node) {
            if (node.left == null && node.right == null) {
                return 0;
            }
            int left = node.left == null ? 0 : dfs(node.left) + 1;
            int right = node.right == null ? 0 : dfs(node.right) + 1;
            max = Math.max(max, right + left);
            return Math.max(left, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
