//一个整数区间 [a, b] ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。 
//
// 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。 
//
// 输出这个最小集合S的大小。 
//
// 示例 1: 
//
// 输入: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
//输出: 3
//解释:
//考虑集合 S = {2, 3, 4}. S与intervals中的四个区间都有至少2个相交的元素。
//且这是S最小的情况，故我们输出3。
// 
//
// 示例 2: 
//
// 输入: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
//输出: 5
//解释:
//最小的集合S = {1, 2, 3, 4, 5}.
// 
//
// 注意: 
//
// 
// intervals 的长度范围为[1, 3000]。 
// intervals[i] 长度为 2，分别代表左、右边界。 
// intervals[i][j] 的值是 [0, 10^8]范围内的整数。 
// 
//
// Related Topics 贪心 数组 排序 👍 126 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java:设置交集大小至少为2
//Time:2022-07-22 14:15:38
class P757_SetIntersectionSizeAtLeastTwo {
    public static void main(String[] args) {
        Solution solution = new P757_SetIntersectionSizeAtLeastTwo().new Solution();
//        System.out.println(solution.intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}}));
//        System.out.println(solution.intersectionSizeTwo(new int[][]{{2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}}));
//        System.out.println(solution.intersectionSizeTwo(new int[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}}));
        System.out.println(solution.intersectionSizeTwo(new int[][]{{1, 3}, {3, 7}, {5, 7}, {7, 8}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
            int sum = 0;
            int left = -1;
            int right = -1;
            for (int[] i :
                    intervals) {
                if (i[0] <= left) {
                    continue;
                }
                if (i[0] > right) {
                    sum += 2;
                    right = i[1];
                    left = right - 1;
                } else {
                    left = right;
                    right = i[1];
                    sum++;
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
