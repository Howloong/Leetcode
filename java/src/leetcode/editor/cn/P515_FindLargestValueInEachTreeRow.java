//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 258 👎 0

package leetcode.editor.cn.java;

import leetcode.editor.cn.java.DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//Java：在每个树行中找最大值
class P515_FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new P515_FindLargestValueInEachTreeRow().new Solution();
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
        public List<Integer> largestValues(TreeNode root) {
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            arrayDeque.offer(root);
            TreeNode p;
            while (!arrayDeque.isEmpty()) {
                int len = arrayDeque.size();
                int max = Integer.MIN_VALUE;
                while (len > 0) {
                    p = arrayDeque.poll();
                    max = Math.max(p.val, max);
                    if (p.left != null) {
                        arrayDeque.offer(p.left);
                    }
                    if (p.right != null) {
                        arrayDeque.offer(p.right);
                    }
                    --len;
                }
                result.add(max);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
