package leetcode.editor.cn.java.DataStruct;

/**
 * @ClassName: ListNode
 * @Package: leetcode.editor.cn.java.DataStruct
 * @Description:
 * @Datetime: 2021/9/24   2:37 下午
 * @Author: YuHan.Kang@outlook.com
 */
public class ListNode {
    public int val;
    public ListNode next, prev, head, tail;
    public int size;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
