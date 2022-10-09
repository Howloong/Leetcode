//给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。 
//
// 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 0
//0:00 ，最晚的是 23:59 。 
//
// 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。 
//
// 返回将 current 转化为 correct 需要的 最少操作数 。 
//
// 
//
// 示例 1： 
//
// 输入：current = "02:30", correct = "04:35"
//输出：3
//解释：
//可以按下述 3 步操作将 current 转换为 correct ：
//- 为 current 加 60 分钟，current 变为 "03:30" 。
//- 为 current 加 60 分钟，current 变为 "04:30" 。 
//- 为 current 加 5 分钟，current 变为 "04:35" 。
//可以证明，无法用少于 3 步操作将 current 转化为 correct 。 
//
// 示例 2： 
//
// 输入：current = "11:00", correct = "11:01"
//输出：1
//解释：只需要为 current 加一分钟，所以最小操作数是 1 。
// 
//
// 
//
// 提示： 
//
// 
// current 和 correct 都符合 "HH:MM" 格式 
// current <= correct 
// 
//
// Related Topics 贪心 字符串 👍 8 👎 0

package leetcode.editor.cn;

//Java:转化时间需要的最少操作数
//Time:2022-10-06 19:39:18
class P2224_MinimumNumberOfOperationsToConvertTime {
    public static void main(String[] args) {
        Solution solution = new P2224_MinimumNumberOfOperationsToConvertTime().new Solution();
        System.out.println(solution.convertTime("02:30", "04:35"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int convertTime(String current, String correct) {
            int h1 = (current.charAt(0) - '0') * 10 + (current.charAt(1) - '0');
            int m1 = (current.charAt(3) - '0') * 10 + (current.charAt(4) - '0');
            int h2 = (correct.charAt(0) - '0') * 10 + (correct.charAt(1) - '0');
            int m2 = (correct.charAt(3) - '0') * 10 + (correct.charAt(4) - '0');
            return convert(h1, m1, h2, m2);
        }

        public int convert(int h1, int m1, int h2, int m2) {
            if (h1 > h2) {
                return convert(h2, m2, h1, m1);
            }
            int min = 60 * h2 + m2 - (60 * h1 + m1);
            int step = 0;
            step += min / 60;
            min %= 60;
            step += min / 15;
            min %= 15;
            step += min / 5;
            min %= 5;
            return step + min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
