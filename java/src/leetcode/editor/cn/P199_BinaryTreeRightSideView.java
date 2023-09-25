//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 714 👎 0

package leetcode.editor.cn.java;

import leetcode.editor.cn.java.DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//Java：二叉树的右视图
class P199_BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new P199_BinaryTreeRightSideView().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
            TreeNode p = root;
            arrayDeque.offer(p);
            while (!arrayDeque.isEmpty()) {
                int len = arrayDeque.size();
                int i = 0;
                while (i < len) {
                    p = arrayDeque.poll();
                    if (p.right != null) {
                        arrayDeque.offer(p.right);
                    }
                    if (p.left != null) {
                        arrayDeque.offer(p.left);
                    }
                    ++i;
                    if (i == 1) {
                        list.add(p.val);
                    }
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
