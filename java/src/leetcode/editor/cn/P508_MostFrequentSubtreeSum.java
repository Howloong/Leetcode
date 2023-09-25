//给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [5,2,-3]
//输出: [2,-3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [5,2,-5]
//输出: [2]
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 174 👎 0

package leetcode.editor.cn.java;

import leetcode.editor.cn.java.DataStruct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Java：出现次数最多的子树元素和
class P508_MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new P508_MostFrequentSubtreeSum().new Solution();
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
        public HashMap<Integer, Integer> hashMap = new HashMap<>();
        public int max = Integer.MIN_VALUE;

        public int[] findFrequentTreeSum(TreeNode root) {
            preOrder(root);
            ArrayList<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> map :
                    hashMap.entrySet()) {
                if (map.getValue() == max) {
                    list.add(map.getKey());
                }
            }
            int[] result = new int[list.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = list.get(i);
            }
            return result;
        }

        public int preOrder(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = preOrder(node.left);
            int right = preOrder(node.right);
            int sum = left + right + node.val;
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            max = Math.max(max, hashMap.get(sum));

            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
