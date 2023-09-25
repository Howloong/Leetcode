//给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。 
//
// 二叉搜索树的定义如下： 
//
// 
// 任意节点的左子树中的键值都 小于 此节点的键值。 
// 任意节点的右子树中的键值都 大于 此节点的键值。 
// 任意节点的左子树和右子树都是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
//输出：20
//解释：键值为 3 的子树是和最大的二叉搜索树。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [4,3,null,1,2]
//输出：2
//解释：键值为 2 的单节点子树是和最大的二叉搜索树。
// 
//
// 示例 3： 
//
// 
//输入：root = [-4,-2,-5]
//输出：0
//解释：所有节点键值都为负数，和最大的二叉搜索树为空。
// 
//
// 示例 4： 
//
// 
//输入：root = [2,1,3]
//输出：6
// 
//
// 示例 5： 
//
// 
//输入：root = [5,4,8,3,null,6,3]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 每棵树有 1 到 40000 个节点。 
// 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 动态规划 二叉树 👍 172 👎 0

package leetcode.editor.cn.java;

import leetcode.editor.cn.java.DataStruct.TreeNode;

//Java:二叉搜索子树的最大键值和
//Time:2023-05-22 09:29:07
class P1373_MaximumSumBstInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P1373_MaximumSumBstInBinaryTree().new Solution();
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
        public int res;

        public int maxSumBST(TreeNode root) {
            dfs(root);
            return res;
        }

        public int[] dfs(TreeNode node) {
            if (node == null) {
                return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
                //0为最小值，1为最大值，2为和
            }
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            int val = node.val;
            if (left[1] >= val || right[0] <= val) {
                return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
            }
            int s = left[2] + right[2] + val;
            res = Math.max(res, s);
            return new int[]{Math.min(left[0], val), Math.max(right[1], val), s};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
