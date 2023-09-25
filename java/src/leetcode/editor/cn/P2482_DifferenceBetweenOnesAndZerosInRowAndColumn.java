//给你一个下标从 0 开始的 m x n 二进制矩阵 grid 。 
//
// 我们按照如下过程，定义一个下标从 0 开始的 m x n 差值矩阵 diff ： 
//
// 
// 令第 i 行一的数目为 onesRowi 。 
// 令第 j 列一的数目为 onesColj 。 
// 令第 i 行零的数目为 zerosRowi 。 
// 令第 j 列零的数目为 zerosColj 。 
// diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj 
// 
//
// 请你返回差值矩阵 diff 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[0,1,1],[1,0,1],[0,0,1]]
//输出：[[0,0,4],[0,0,4],[-2,-2,2]]
//解释：
//- diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 2 + 1 - 1 - 2 = 0
// 
//- diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 2 + 1 - 1 - 2 = 0
// 
//- diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 2 + 3 - 1 - 0 = 4
// 
//- diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 2 + 1 - 1 - 2 = 0
// 
//- diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 2 + 1 - 1 - 2 = 0
// 
//- diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 2 + 3 - 1 - 0 = 4
// 
//- diff[2][0] = onesRow2 + onesCol0 - zerosRow2 - zerosCol0 = 1 + 1 - 2 - 2 = -
//2
//- diff[2][1] = onesRow2 + onesCol1 - zerosRow2 - zerosCol1 = 1 + 1 - 2 - 2 = -
//2
//- diff[2][2] = onesRow2 + onesCol2 - zerosRow2 - zerosCol2 = 1 + 3 - 2 - 0 = 2
//
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[1,1,1],[1,1,1]]
//输出：[[5,5,5],[5,5,5]]
//解释：
//- diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 3 + 2 - 0 - 0 = 5
//
//- diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 3 + 2 - 0 - 0 = 5
//
//- diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 3 + 2 - 0 - 0 = 5
//
//- diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 3 + 2 - 0 - 0 = 5
//
//- diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 3 + 2 - 0 - 0 = 5
//
//- diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 3 + 2 - 0 - 0 = 5
//
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// grid[i][j] 要么是 0 ，要么是 1 。 
// 
//
// Related Topics 数组 矩阵 模拟 👍 6 👎 0

package leetcode.editor.cn.java;

import java.util.Arrays;

//Java:行和列中一和零的差值
//Time:2023-03-16 13:27:55
class P2482_DifferenceBetweenOnesAndZerosInRowAndColumn {
    public static void main(String[] args) {
        Solution solution = new P2482_DifferenceBetweenOnesAndZerosInRowAndColumn().new Solution();
        System.out.println(Arrays.deepToString(solution.onesMinusZeros(new int[][]{{0, 1, 1}, {1, 0, 1}, {0, 0, 1}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] onesMinusZeros(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] res = new int[m][n];
            int[] rowCnt = new int[m];
            int[] colCnt = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rowCnt[i] += grid[i][j];
                }
            }
            for (int j = 0; j < n; j++) {
                for (int[] ints : grid) {
                    colCnt[j] += ints[j];
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 2 * rowCnt[i] + 2 * colCnt[j] - m - n;
                }
            }
            return grid;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
