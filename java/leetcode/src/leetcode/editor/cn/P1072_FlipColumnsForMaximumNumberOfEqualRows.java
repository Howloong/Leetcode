//给定 m x n 矩阵 matrix 。 
//
// 你可以从中选出任意数量的列并翻转其上的 每个 单元格。（即翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。） 
//
// 返回 经过一些翻转后，行与行之间所有值都相等的最大行数 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[0,1],[1,1]]
//输出：1
//解释：不进行翻转，有 1 行所有值都相等。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1],[1,0]]
//输出：2
//解释：翻转第一列的值之后，这两行都由相等的值组成。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[0,0,0],[0,0,1],[1,1,0]]
//输出：2
//解释：翻转前两列的值之后，后两行由相等的值组成。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] == 0 或 1 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 80 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java:按列翻转得到最大值等行数
//Time:2023-05-15 09:05:08
class P1072_FlipColumnsForMaximumNumberOfEqualRows {
    public static void main(String[] args) {
        Solution solution = new P1072_FlipColumnsForMaximumNumberOfEqualRows().new Solution();
        System.out.println(solution.maxEqualRowsAfterFlips(new int[][]{{0, 0, 0}, {0, 0, 1}, {1, 1, 0}}));
        System.out.println(solution.maxEqualRowsAfterFlips(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(solution.maxEqualRowsAfterFlips(new int[][]{{0, 1}, {1, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            int n = matrix[0].length;
            int t = (1 << n) - 1;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int[] ints : matrix) {
                int sum = 0;
                for (int i = n - 1; i >= 0; i--) {
                    sum += ints[i] * (1 << (n - i - 1));
                }
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            }
            int res = 0;
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                res = Math.max(res, entry.getValue() + hashMap.getOrDefault(t - entry.getKey(), 0));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
