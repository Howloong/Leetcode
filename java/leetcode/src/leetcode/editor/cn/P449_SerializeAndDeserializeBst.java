//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
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
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 447 👎 0

package leetcode.editor.cn;


import leetcode.editor.cn.DataStruct.TreeNode;

//Java:序列化和反序列化二叉搜索树
//Time:2023-09-04 09:51:55
class P449_SerializeAndDeserializeBst {
    public static void main(String[] args) {
        Codec codec = new P449_SerializeAndDeserializeBst().new Codec();
        var deserialize = codec.deserialize("4,2,1,3,6,5,7");
        var serialize = codec.serialize(deserialize);
        System.out.println(serialize);
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
        private StringBuilder stringBuilder;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            this.stringBuilder=new StringBuilder();
            inOrder(root);
            return stringBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isBlank()) {
                return null;
            }
            String[] nodes = data.split(",");
            return strToTree(nodes, 0, nodes.length-1);
        }

        public void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            this.stringBuilder.append(node.val).append(",");
            inOrder(node.left);
            inOrder(node.right);
        }

        public TreeNode strToTree(String[] nodes, int start, int end) {
            if (start > end) {
                return null;
            }
            int l = start + 1;
            int r = end;
            int t = Integer.parseInt(nodes[start]);
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (Integer.parseInt(nodes[mid]) > t) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (Integer.parseInt(nodes[r]) <= t) {
                r++;
            }
            TreeNode ans = new TreeNode(t);
            ans.left = strToTree(nodes, start + 1, r - 1);
            ans.right = strToTree(nodes, r, end);
            return ans;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}
