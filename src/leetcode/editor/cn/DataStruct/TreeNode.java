package leetcode.editor.cn.DataStruct;

/**
 * @ClassName: TreeNode
 * @Package: leetcode.editor.cn.DataStruct
 * @Description:
 * @Datetime: 2021/9/29   5:25 下午
 * @Author: YuHan.Kang@outlook.com
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}