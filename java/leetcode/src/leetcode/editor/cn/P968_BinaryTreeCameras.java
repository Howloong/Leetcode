//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 443 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.DataStruct.TreeNode;

//Java:监控二叉树
//Time:2022-07-23 16:39:46
class P968_BinaryTreeCameras {
    public static void main(String[] args) {
        Solution solution = new P968_BinaryTreeCameras().new Solution();
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
        public int sum = 0;

        public int minCameraCover(TreeNode root) {
            if (postOrder(root) == 0) {
                sum++;
            }
            return sum;
        }

        /*
         * 0:无覆盖
         * 1:有覆盖
         * 2:有摄像头
         * */
        public int postOrder(TreeNode node) {
            if (node == null) {
                return 1;
            }
            int left = postOrder(node.left);
            int right = postOrder(node.right);
            if (left == 1 && right == 1) {
                return 0;
            }
            if (left == 0 || right == 0) {
                sum++;
                return 2;
            }
            if (left == 2 || right == 2) {
                return 1;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
