//给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n² 分钟内修好
// n 辆车。 
//
// 同时给你一个整数 cars ，表示总共需要修理的汽车数目。 
//
// 请你返回修理所有汽车 最少 需要多少时间。 
//
// 注意：所有机械工可以同时修理汽车。 
//
// 
//
// 示例 1： 
//
// 
//输入：ranks = [4,2,3,1], cars = 10
//输出：16
//解释：
//- 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
//- 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
//- 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
//- 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//16 分钟是修理完所有车需要的最少时间。
// 
//
// 示例 2： 
//
// 
//输入：ranks = [5,1,8], cars = 6
//输出：16
//解释：
//- 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
//- 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//- 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
//16 分钟时修理完所有车需要的最少时间。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ranks.length <= 10⁵ 
// 1 <= ranks[i] <= 100 
// 1 <= cars <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 👍 126 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;

//Java:修车的最少时间
//Time:2023-09-07 15:53:55
class P2594_MinimumTimeToRepairCars {
    public static void main(String[] args) {
        Solution solution = new P2594_MinimumTimeToRepairCars().new Solution();
        System.out.println(solution.repairCars(new int[]{4, 2, 3, 1}, 10));
        System.out.println(solution.repairCars(new int[]{5, 1, 8}, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long repairCars(int[] ranks, int cars) {
            Arrays.sort(ranks);
            long left = ranks[0];
            long right = (long) ranks[ranks.length - 1] * cars * cars;
            while (left < right) {
                long mid = left + (right - left) / 2;
                if (func(cars, ranks, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public boolean func(int car, int[] ranks, long time) {
            long res = 0;
            for (int rank : ranks) {
                res += (long) Math.sqrt(time / rank);
            }
            return res >= car;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
