//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
// root 。 
//
// 除了
// root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的
//房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1432 👎 0

package leetcode.editor.cn;



import leetcode.editor.cn.DataStruct.TreeNode;

import static java.lang.Math.max;

//Java:打家劫舍 III
//Time:2022-09-11 22:22:44
class P337_HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new P337_HouseRobberIii().new Solution();
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

        public int rob(TreeNode root) {
            int[] res = inOrder(root);
            return max(res[0], res[1]);
        }

        public int[] inOrder(TreeNode node) {
            if (node == null) {
                return new int[]{0, 0};
            }
//            0不选，1选
            int[] left = inOrder(node.left);
            int[] right = inOrder(node.right);
            int val1 = node.val + left[0] + right[0];
            int val2 = max(left[0], left[1]) + max(right[0], right[1]);
            return new int[]{val2, val1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
