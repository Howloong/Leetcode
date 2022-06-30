//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 588 👎 0

package leetcode.editor.cn;

import com.sun.source.tree.Tree;
import leetcode.editor.cn.DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java：二叉树的层序遍历 II
class P107_BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new P107_BinaryTreeLevelOrderTraversalIi().new Solution();
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
            List<List<Integer>> result = new ArrayList<>();
            arrayDeque.offer(root);
            TreeNode p = root;
            while (!arrayDeque.isEmpty()) {
                int len = arrayDeque.size();
                List<Integer> list = new ArrayList<>();
                while (len > 0) {
                    p = arrayDeque.poll();
                    list.add(p.val);
                    if (p.left != null) {
                        arrayDeque.offer(p.left);
                    }
                    if (p.right != null) {
                        arrayDeque.offer(p.right);
                    }
                    --len;
                }
                result.add(list);
            }
            Collections.reverse(result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
