//请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, 
//numberOfUnitsPerBoxi] ： 
//
// 
// numberOfBoxesi 是类型 i 的箱子的数量。 
// numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。 
// 
//
// 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。 
//
// 返回卡车可以装载 单元 的 最大 总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
//输出：8
//解释：箱子的情况如下：
//- 1 个第一类的箱子，里面含 3 个单元。
//- 2 个第二类的箱子，每个里面含 2 个单元。
//- 3 个第三类的箱子，每个里面含 1 个单元。
//可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
//单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8 
//
// 示例 2： 
//
// 
//输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
//输出：91
// 
//
// 
//
// 提示： 
//
// 
// 1 <= boxTypes.length <= 1000 
// 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000 
// 1 <= truckSize <= 10⁶ 
// 
//
// Related Topics 贪心 数组 排序 👍 93 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java:卡车上的最大单元数
//Time:2022-11-15 17:35:18
class P1710_MaximumUnitsOnATruck {
    public static void main(String[] args) {
        Solution solution = new P1710_MaximumUnitsOnATruck().new Solution();
//        System.out.println(solution.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
        System.out.println(solution.maximumUnits(new int[][]{{1, 3}, {5, 5}, {2, 5}, {4, 2}, {4, 1}, {3, 1}, {2, 2}, {1, 3}, {2, 5}, {3, 2}}, 35));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, Comparator.comparingInt(a -> -a[1]));
            int sum = 0;
            int i = 0;
            int k = 0;
            while (i < truckSize) {
                int j = 0;
                if (k == boxTypes.length) {
                    break;
                }
                while (j < boxTypes[k][0] && i < truckSize) {
                    sum += boxTypes[k][1];
                    j++;
                    i++;
                }
                k++;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
