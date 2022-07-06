//实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。 
//
// 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。 
//
// 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为， start <= x < 
//end 。 
//
// 实现 MyCalendar 类： 
//
// 
// MyCalendar() 初始化日历对象。 
// boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 
//false 并且不要将该日程安排添加到日历中。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyCalendar", "book", "book", "book"]
//[[], [10, 20], [15, 25], [20, 30]]
//输出：
//[null, true, false, true]
//
//解释：
//MyCalendar myCalendar = new MyCalendar();
//myCalendar.book(10, 20); // return True
//myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了
//。
//myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20
// ，且不包含时间 20 。 
//
// 
//
// 提示： 
//
// 
// 0 <= start < end <= 10⁹ 
// 每个测试用例，调用 book 方法的次数最多不超过 1000 次。 
// 
// Related Topics 设计 线段树 二分查找 有序集合 👍 186 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.TreeSet;

//Java：我的日程安排表 I
class P729_MyCalendarI {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(10, 20));
        // return True
        System.out.println(myCalendar.book(15, 25)); // return False
        System.out.println(myCalendar.book(20, 30)); // return False
    }


}

//leetcode submit region begin(Prohibit modification and deletion)
class MyCalendar {
    TreeSet<int[]> treeSet;

    public MyCalendar() {
        treeSet = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    }

    public boolean book(int start, int end) {
        if (this.treeSet.size() == 0) {
            treeSet.add(new int[]{start, end});
            return true;
        }
        if (start >= treeSet.last()[1] || end <=treeSet.first()[0]) {
            treeSet.add(new int[]{start, end});
            return true;
        }
        int[] temp = new int[]{end, 0};
        int[] after = treeSet.ceiling(temp);
        if (after == null) {
            return false;
        }
        int[] before = treeSet.lower(after);
        if (before != null && before[1] <= start) {
            treeSet.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)