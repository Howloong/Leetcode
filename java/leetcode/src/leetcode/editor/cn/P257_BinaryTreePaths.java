//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 774 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的所有路径
class P257_BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257_BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            preOrder(root, "", res);
            return res;
        }

        public void preOrder(TreeNode p, String s, List<String> res) {
            if (p.left == null && p.right == null) {
                res.add(s + p.val);
                return;
            }
            if (p.left != null)
                preOrder(p.left, s + p.val + "->", res);
            if (p.right != null) {
                preOrder(p.right, s + p.val + "->", res);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
