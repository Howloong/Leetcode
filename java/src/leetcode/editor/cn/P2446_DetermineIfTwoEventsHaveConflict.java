//给你两个字符串数组 event1 和 event2 ，表示发生在同一天的两个闭区间时间段事件，其中： 
//
// 
// event1 = [startTime1, endTime1] 且 
// event2 = [startTime2, endTime2] 
// 
//
// 事件的时间为有效的 24 小时制且按 HH:MM 格式给出。 
//
// 当两个事件存在某个非空的交集时（即，某些时刻是两个事件都包含的），则认为出现 冲突 。 
//
// 如果两个事件之间存在冲突，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
//输出：true
//解释：两个事件在 2:00 出现交集。
// 
//
// 示例 2： 
//
// 
//输入：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
//输出：true
//解释：两个事件的交集从 01:20 开始，到 02:00 结束。
// 
//
// 示例 3： 
//
// 
//输入：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
//输出：false
//解释：两个事件不存在交集。
// 
//
// 
//
// 提示： 
//
// 
// evnet1.length == event2.length == 2. 
// event1[i].length == event2[i].length == 5 
// startTime1 <= endTime1 
// startTime2 <= endTime2 
// 所有事件的时间都按照 HH:MM 格式给出 
// 
//
// Related Topics 数组 字符串 👍 26 👎 0

package leetcode.editor.cn.java;

//Java:判断两个事件是否存在冲突
//Time:2023-05-17 09:20:55
class P2446_DetermineIfTwoEventsHaveConflict {
    public static void main(String[] args) {
        Solution solution = new P2446_DetermineIfTwoEventsHaveConflict().new Solution();
        System.out.println(solution.haveConflict(new String[]{"10:00", "11:00"}, new String[]{"14:00", "15:00"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean haveConflict(String[] event1, String[] event2) {
            int start_1 = transfer(event1[0]);
            int end_1 = transfer(event1[1]);
            int start_2 = transfer(event2[0]);
            int end_2 = transfer(event2[1]);
            return start_1 <= start_2 ? end_1 >= start_2 : end_2 >= start_1;
        }

        public int transfer(String string) {
            int t1 = 10 * (string.charAt(0) - '0') + (string.charAt(1) - '0');
            int t2 = 10 * (string.charAt(3) - '0') + (string.charAt(4) - '0');
            return 60 * t1 + t2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
