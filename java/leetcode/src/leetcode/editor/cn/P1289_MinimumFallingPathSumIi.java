//给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。 
//
// 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
//输出：13
//解释：
//所有非零偏移下降路径包括：
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[7]]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// -99 <= grid[i][j] <= 99 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 185 👎 0

package leetcode.editor.cn;

//Java:下降路径最小和  II
//Time:2023-08-22 15:22:29
class P1289_MinimumFallingPathSumIi {
    public static void main(String[] args) {
        Solution solution = new P1289_MinimumFallingPathSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] dp = new int[n];
            int[] min = new int[4];
            min[0] = Integer.MAX_VALUE;
            min[1] = 0;
            min[2] = grid[0][0];
            min[3] = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                dp[i] = grid[0][i];
                getMin(dp, min, i);
            }
            for (int i = 1; i < m; i++) {
                int[] temp = new int[4];
                temp[0] = Integer.MAX_VALUE;
                temp[1] = 0;
                temp[2] = Integer.MAX_VALUE;
                temp[3] = 0;
                for (int j = 0; j < n; j++) {
                    if (min[1] != j) {
                        dp[j] = min[0] + grid[i][j];
                    } else {
                        dp[j] = min[2] + grid[i][j];
                    }

                    getMin(dp, temp, j);
                }
                System.arraycopy(temp, 0, min, 0, 4);
            }
            return min[0];
        }

        private void getMin(int[] dp, int[] temp, int j) {
            if (dp[j] < temp[0]) {
                temp[2] = temp[0];
                temp[3] = temp[1];
                temp[0] = dp[j];
                temp[1] = j;
            } else if (dp[j] < temp[2]) {
                temp[2] = dp[j];
                temp[3] = j;
            }
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
