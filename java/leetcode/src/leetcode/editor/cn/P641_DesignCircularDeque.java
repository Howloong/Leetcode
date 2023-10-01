//设计实现双端队列。 
//
// 实现 MyCircularDeque 类: 
//
// 
// MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。 
// boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。 
// boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。 
// boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。 
// boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。 
// int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。 
// int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。 
// boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false 。 
// boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", 
//"getRear", "isFull", "deleteLast", "insertFront", "getFront"]
//[[3], [1], [2], [3], [4], [], [], [], [4], []]
//输出
//[null, true, true, true, false, 2, true, true, true, 4]
//
//解释
//MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 1000 
// 0 <= value <= 1000 
// insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty,
// isFull 调用次数不大于 2000 次 
// 
//
// Related Topics 设计 队列 数组 链表 👍 180 👎 0

package leetcode.editor.cn;

//Java:设计循环双端队列
//Time:2022-08-15 22:47:28
class P641_DesignCircularDeque {
    public static void main(String[] args) {
        int k = 10;
        MyCircularDeque obj = new P641_DesignCircularDeque().new MyCircularDeque(3);
        System.out.println(obj.insertLast(1));
        System.out.println(obj.insertLast(2));
        System.out.println(obj.insertFront(3));
        System.out.println(obj.insertFront(4));
        System.out.println(obj.getRear());
        System.out.println(obj.isFull());
        System.out.println(obj.deleteLast());
        System.out.println(obj.insertFront(4));
        System.out.println(obj.getFront());

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {

        public int[] queue;
        public int front;
        public int rear;
        public int size;
        public int length;

        public MyCircularDeque(int k) {
            queue = new int[k];
            size = k;
            front = 0;
            rear = 0;
            length = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            length++;
            front--;
            if (front == -1) {
                front = size - 1;
            }
            queue[front] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            length++;
            queue[rear] = value;
            rear++;
            if (rear == size) {
                rear = 0;
            }
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            length--;
            front++;
            if (front == size) {
                front = 0;
            }
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            length--;
            rear--;
            if (rear == -1) {
                rear = size - 1;
            }
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : queue[front];
        }

        public int getRear() {
            return isEmpty() ? -1 : queue[rear - 1 == -1 ? size - 1 : rear - 1];
        }

        public boolean isEmpty() {
            return length == 0;
        }

        public boolean isFull() {
            return length == size;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
