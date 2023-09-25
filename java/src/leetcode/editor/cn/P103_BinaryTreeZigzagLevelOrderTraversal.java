//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
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
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 798 👎 0

package leetcode.editor.cn.java;

import leetcode.editor.cn.java.DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java:二叉树的锯齿形层序遍历
//Time:2023-08-22 15:26:15
class P103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            int direction = 1;
            while (!deque.isEmpty()) {
                int len = deque.size();
                int index = 0;
                List<Integer> list = new ArrayList<>();
                while (index++ < len) {
                    TreeNode node;
                    if (direction == -1) {
                        node = deque.pollLast();
                        if (node.right != null) {
                            deque.offerFirst(node.right);
                        }
                        if (node.left != null) {
                            deque.offerFirst(node.left);
                        }
                    } else {
                        node = deque.pollFirst();
                        if (node.left != null) {
                            deque.offerLast(node.left);
                        }
                        if (node.right != null) {
                            deque.offerLast(node.right);
                        }
                    }

                    list.add(node.val);
                }
                direction = -direction;
                res.add(list);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
