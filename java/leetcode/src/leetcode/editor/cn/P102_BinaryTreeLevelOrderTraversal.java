//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
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
// Related Topics 树 广度优先搜索 二叉树 👍 1370 👎 0

package leetcode.editor.cn;


import leetcode.editor.cn.DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//Java：二叉树的层序遍历
class P102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102_BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            TreeNode p = root;
            arrayDeque.offer(root);
            while (!arrayDeque.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int len = arrayDeque.size();
                while (len > 0) {
                    p = arrayDeque.poll();
                    list.add(p.val);
                    if (p.left != null)
                        arrayDeque.offer(p.left);
                    if (p.right != null)
                        arrayDeque.offer(p.right);
                    --len;
                }
                result.add(list);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
