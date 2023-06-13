//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints.length <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// Related Topics 数组 数学 字符串 排序 👍 206 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java:最小时间差
//Time:2022-08-07 19:31:29
class P539_MinimumTimeDifference {
    public static void main(String[] args) {
        Solution solution = new P539_MinimumTimeDifference().new Solution();
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        list.add("00:00");
        System.out.println(solution.findMinDifference(list));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            List<Integer> res = new ArrayList<>();
            for (String timePoint : timePoints) {
                res.add(stringToTimes(timePoint));
            }
            Collections.sort(res);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < res.size() - 1; i++) {
                min = Math.min(min, res.get(i + 1) - res.get(i));
            }
            min = Math.min(min, 1440 - (res.get(res.size() - 1) - res.get(0)));
            return min;
        }

        public int stringToTimes(String timePoints) {
            int hour = (timePoints.charAt(0) - '0') * 10 + (timePoints.charAt(1) - '0');
            int minutes = (timePoints.charAt(3) - '0') * 10 + (timePoints.charAt(4) - '0');
            return hour * 60 + minutes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
