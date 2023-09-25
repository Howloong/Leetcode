//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
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
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 1138 👎 0

package leetcode.editor.cn.java;

import leetcode.editor.cn.java.DataStruct.TreeNode;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.StringJoiner;

//Java:二叉树的序列化与反序列化
//Time:2023-08-08 21:11:42
class P297_SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringJoiner sj = new StringJoiner(",");
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
            arrayDeque.offer(root);
            sj.add(Integer.toString(root.val));
            while (!arrayDeque.isEmpty()) {
                int len = arrayDeque.size();
                int idx = 0;
                while (idx++ < len) {
                    TreeNode peek = arrayDeque.poll();
                    if (peek.left == null) {
                        sj.add("null");
                    } else {
                        sj.add(Integer.toString(peek.left.val));
                        arrayDeque.offer(peek.left);
                    }
                    if (peek.right == null) {
                        sj.add("null");
                    } else {
                        sj.add(Integer.toString(peek.right.val));
                        arrayDeque.offer(peek.right);
                    }
                }
            }
            return sj.toString();
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (Objects.equals(data, "")) {
                return null;
            }
            String[] strNodes = data.split(",");
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
            TreeNode root = new TreeNode(Integer.parseInt(strNodes[0]));
            arrayDeque.offer(root);
            int index = 1;
            int n = strNodes.length;
            while (index < n) {
                TreeNode node = arrayDeque.poll();
                if (!strNodes[index].equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(strNodes[index]));
                    node.left = left;
                    arrayDeque.offer(left);
                }
                index++;
                if (index < n && !strNodes[index].equals("null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(strNodes[index]));
                    node.right = right;
                    arrayDeque.offer(right);
                }
                index++;
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
