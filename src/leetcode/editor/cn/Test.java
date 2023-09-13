package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class Test {
    public static void main(String[] args) {
        String[] strings = new String[2];
        int length = strings.length;
    }


    public Node func(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
