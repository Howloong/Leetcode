//我们给出了一个（轴对齐的）二维矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是
//矩形 i 左下角的坐标，
// (xi1, yi1) 是该矩形 左下角 的坐标，
// (xi2, yi2) 是该矩形 右上角 的坐标。 
//
// 计算平面中所有 rectangles 所覆盖的 总面积 。任何被两个或多个矩形覆盖的区域应只计算 一次 。 
//
// 返回 总面积 。因为答案可能太大，返回
// 10⁹ + 7 的 模 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
//输出：6
//解释：如图所示，三个矩形覆盖了总面积为6的区域。
//从(1,1)到(2,2)，绿色矩形和红色矩形重叠。
//从(1,0)到(2,3)，三个矩形都重叠。
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[0,0,1000000000,1000000000]]
//输出：49
//解释：答案是 10¹⁸ 对 (10⁹ + 7) 取模的结果， 即 49 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 200 
// rectanges[i].length = 4
// 
// 0 <= xi1, yi1, xi2, yi2 <= 10⁹ 
// 矩形叠加覆盖后的总面积不会超越 2^63 - 1 ，这意味着可以用一个 64 位有符号整数来保存面积结果。 
// 
//
// Related Topics 线段树 数组 有序集合 扫描线 👍 185 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java:矩形面积 II
//Time:2022-09-16 15:50:12
class P850_RectangleAreaIi {
    public static void main(String[] args) {
        Solution solution = new P850_RectangleAreaIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rectangleArea(int[][] rectangles) {
            int MOD = (int) (1e9 + 7);
            List<Integer> list = new ArrayList<>();
            for (int[] rectangle : rectangles) {
                list.add(rectangle[0]);
                list.add(rectangle[2]);
            }
            Collections.sort(list);
            long ans = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int a = list.get(i);
                int b = list.get(i + 1);
                int len = b - a;
                if (len == 0) {
                    continue;
                }
                List<int[]> lines = new ArrayList<>();
                for (int[] rectangle : rectangles) {
                    if (rectangle[0] <= a && b <= rectangle[2]) {
                        lines.add(new int[]{rectangle[1], rectangle[3]});
                    }
                }
                lines.sort((l1, l2) -> l1[0] == l2[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
                //定义tot存储当前x区间下，y区间的并集，l，r为上一个y区间端点
                long tot = 0, l = -1, r = -1;
                for (int[] line : lines) {
                    if (line[0] > r) {
                        tot += (r - l);
                        r = line[1];
                        l = line[0];
                    } else if (line[1] > r) {
                        r = line[1];
                    }
                }
                tot += (r - l);
                ans += (tot * len);
                ans %= MOD;
            }
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
