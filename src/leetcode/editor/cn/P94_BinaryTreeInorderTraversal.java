//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1471 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//Java：二叉树的中序遍历
class P94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();
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
        /*        public List<Integer> inorderTraversal(TreeNode root) {
                    List<Integer> list = new ArrayList<>();
                    inOrder(root, list);
                    return list;
                }

                public void inOrder(TreeNode node, List<Integer> list) {
                    if (node == null) {
                        return;
                    }
                    inOrder(node.left, list);
                    list.add(node.val);
                    inOrder(node.right, list);
                }*/
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
            List<Integer> result = new ArrayList<>();
            TreeNode p = root;
            while (p != null || !arrayDeque.isEmpty()) {
                if (p != null) {
                    arrayDeque.push(p);
                    p = p.left;
                } else {
                    p = arrayDeque.pop();
                    result.add(p.val);
                    p = p.right;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
