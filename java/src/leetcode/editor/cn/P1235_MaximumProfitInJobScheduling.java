//你打算利用空闲时间来做兼职工作赚些零花钱。 
//
// 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。 
//
// 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。 
//
// 注意，时间上出现重叠的 2 份工作不能同时进行。 
//
// 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//输出：120
//解释：
//我们选出第 1 份和第 4 份工作， 
//时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
// 
//
// 示例 2： 
//
// 
//
// 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60
//]
//输出：150
//解释：
//我们选择第 1，4，5 份工作。 
//共获得报酬 150 = 20 + 70 + 60。
// 
//
// 示例 3： 
//
// 
//
// 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4 
// 1 <= startTime[i] < endTime[i] <= 10^9 
// 1 <= profit[i] <= 10^4 
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 280 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;
import java.util.Comparator;

//Java:规划兼职工作
//Time:2022-10-22 19:33:14
class P1235_MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        Solution solution = new P1235_MaximumProfitInJobScheduling().new Solution();
//        System.out.println(solution.jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
//        System.out.println(solution.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
//        System.out.println(solution.jobScheduling(new int[]{4, 2, 4, 8, 2}, new int[]{5, 5, 5, 10, 8}, new int[]{1, 2, 8, 10, 4}));
        System.out.println(solution.jobScheduling(new int[]{43, 13, 36, 31, 40, 5, 47, 13, 28, 16, 2, 11}, new int[]{44, 22, 41, 41, 47, 13, 48, 35, 48, 26, 21, 39}, new int[]{8, 20, 3, 19, 16, 8, 11, 13, 2, 15, 1, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int len = startTime.length;
            int[][] end = new int[len][3];
            for (int i = 0; i < len; i++) {
                end[i][0] = startTime[i];
                end[i][1] = endTime[i];
                end[i][2] = profit[i];
            }
            Arrays.sort(end, Comparator.comparingInt(a -> a[1]));
            int[] dp = new int[len + 1];
            for (int i = 0; i < len; i++) {
                int j = binarySearch(end, i, end[i][0]);
                dp[i + 1] = Math.max(dp[i], dp[1 + j] + end[i][2]);
            }
            return dp[len];
        }

        public int binarySearch(int[][] array, int right, int max) {
            int left = -1;
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (array[mid][1] <= max) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
