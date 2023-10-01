//给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10⁻⁵ 以内的答案可以被接受。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[3.00000,14.50000,11.00000]
//解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
//因此返回 [3, 14.5, 11] 。
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [3,9,20,15,7]
//输出：[3.00000,14.50000,11.00000]
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 树中节点数量在 [1, 10⁴] 范围内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 355 👎 0

package leetcode.editor.cn;


import leetcode.editor.cn.DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//Java：二叉树的层平均值
class P637_AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P637_AverageOfLevelsInBinaryTree().new Solution();
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
        public List<Double> averageOfLevels(TreeNode root) {
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
            List<Double> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            arrayDeque.offer(root);
            TreeNode p;
            while (!arrayDeque.isEmpty()) {
                int len = arrayDeque.size();
                int i = len;
                double sum = 0;
                while (i > 0) {
                    p = arrayDeque.poll();
                    sum += p.val;
                    if (p.left != null) {
                        arrayDeque.offer(p.left);
                    }
                    if (p.right != null) {
                        arrayDeque.offer(p.right);
                    }
                    --i;
                }
                result.add(sum / len);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
