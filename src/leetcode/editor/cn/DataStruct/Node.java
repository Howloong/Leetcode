package leetcode.editor.cn.DataStruct;

import java.util.List;

/**
 * @ClassName: Node
 * @Package: leetcode.editor.cn.DataStruct
 * @Description:
 * @Datetime: 2021/10/4   2:31 下午
 * @Author: YuHan.Kang@outlook.com
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}